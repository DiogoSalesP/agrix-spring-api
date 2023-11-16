package com.trybe.agrixspringapi.service;

import com.trybe.agrixspringapi.model.entity.Crop;
import com.trybe.agrixspringapi.model.entity.Farm;
import com.trybe.agrixspringapi.model.repository.CropRepository;
import com.trybe.agrixspringapi.model.repository.FarmRepository;
import com.trybe.agrixspringapi.service.exception.FarmNotFound;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {

  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }

  public Crop createCrop(Long id, Crop crop) {
    Farm farm = findById(id);
    crop.setFarm(farm);
    Crop cropFromDB = cropRepository.save(crop);
    farm.setCrops(cropFromDB);
    return cropFromDB;
  }

  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  public Farm findById(Long id) {
    return farmRepository.findById(id).orElseThrow(FarmNotFound::new);
  }

  public Farm update(Long id, Farm farm) {
    Farm farmFromDB = findById(id);
    updateData(farmFromDB, farm);
    return farmRepository.save(farmFromDB);
  }

  public void delete(Long id) {
    Farm farm = findById(id);
    farmRepository.deleteById(farm.getId());
  }

  private void updateData(Farm farmFromDB, Farm farm) {
    farmFromDB.setName(farm.getName());
    farmFromDB.setSize(farm.getSize());
  }
}

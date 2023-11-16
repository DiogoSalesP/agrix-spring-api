package com.trybe.agrixspringapi.service;

import com.trybe.agrixspringapi.model.entity.Crop;
import com.trybe.agrixspringapi.model.repository.CropRepository;
import com.trybe.agrixspringapi.service.exception.CropNotFound;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropService {

  private final CropRepository cropRepository;

  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  public Crop create(Crop crop) {
    return cropRepository.save(crop);
  }

  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  public Crop findById(Long id) {
    return cropRepository.findById(id).orElseThrow(CropNotFound::new);
  }

  public List<Crop> findCropByFarmId(Long id) {
    List<Crop> crops = new ArrayList<>();
    for (Crop crop : findAll()) {
      if (crop.getFarm().getId().equals(id)) {
        crops.add(crop);
      }
    }
    return crops;
  }

  public Crop update(Long id, Crop crop) {
    Crop cropFromDB = findById(id);
    updateData(cropFromDB, crop);
    return cropRepository.save(cropFromDB);
  }

  public void delete(Long id) {
    Crop crop = findById(id);
    cropRepository.deleteById(crop.getId());
  }

  private void updateData(Crop cropFromDB, Crop crop) {
    cropFromDB.setName(crop.getName());
    cropFromDB.setPlantedArea(crop.getPlantedArea());
  }
}

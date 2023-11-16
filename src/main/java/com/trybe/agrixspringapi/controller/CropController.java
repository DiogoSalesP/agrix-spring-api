package com.trybe.agrixspringapi.controller;

import com.trybe.agrixspringapi.controller.dto.CropDto;
import com.trybe.agrixspringapi.model.entity.Crop;
import com.trybe.agrixspringapi.service.CropService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  @GetMapping
  public ResponseEntity<List<Crop>> findAll() {
    List<Crop> crops = cropService.findAll();
    return ResponseEntity.ok(
        crops.stream()
            .map((crop -> new CropDto(crop.getId(), crop.getName(),
                crop.getPlantedArea()).toEntity()))
            .collect(
                Collectors.toList())
    );
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Crop> findById(@PathVariable Long id) {
    return ResponseEntity.ok(cropService.findById(id));
  }

}

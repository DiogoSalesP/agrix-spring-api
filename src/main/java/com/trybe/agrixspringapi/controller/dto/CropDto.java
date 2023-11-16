package com.trybe.agrixspringapi.controller.dto;

import com.trybe.agrixspringapi.model.entity.Crop;
import com.trybe.agrixspringapi.model.entity.Farm;

public record CropDto(Long id, String name, Double plantedArea, Long farmId) {

  public Crop toEntity() {
    return new Crop(id, name, plantedArea);
  }

  public CropDto toEntityWithFarmId() {
    return new CropDto(id, name, plantedArea, farmId);
  }

}

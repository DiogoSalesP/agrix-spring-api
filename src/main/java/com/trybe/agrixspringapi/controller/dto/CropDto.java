package com.trybe.agrixspringapi.controller.dto;

import com.trybe.agrixspringapi.model.entity.Crop;

public record CropDto(Long id, String name, Double plantedArea) {

  public Crop toEntity() {
    return new Crop(id, name, plantedArea);
  }

}

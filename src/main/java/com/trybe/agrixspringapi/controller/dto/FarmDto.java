package com.trybe.agrixspringapi.controller.dto;

import com.trybe.agrixspringapi.model.entity.Farm;

public record FarmDto(Long id, String name, Double size) {

  public Farm toEntity() {
    return new Farm(id, name, size);
  }

}

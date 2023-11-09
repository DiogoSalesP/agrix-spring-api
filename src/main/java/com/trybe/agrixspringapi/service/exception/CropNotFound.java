package com.trybe.agrixspringapi.service.exception;

public class CropNotFound extends NotFoundException {
  
  public CropNotFound() {
    super("Crop not found !");
  }
}

package com.trybe.agrixspringapi.service.exception;

public class FarmNotFound extends NotFoundException {
  public FarmNotFound() {
    super("Farm not found !");
  }
}

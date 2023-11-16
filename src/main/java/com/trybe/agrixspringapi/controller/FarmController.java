package com.trybe.agrixspringapi.controller;

import com.trybe.agrixspringapi.controller.dto.FarmDto;
import com.trybe.agrixspringapi.model.entity.Farm;
import com.trybe.agrixspringapi.service.FarmService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  @PostMapping
  public ResponseEntity<Farm> created(@RequestBody FarmDto farmDto) {
    Farm farm = farmService.create(farmDto.toEntity());
    return ResponseEntity.ok(farm);
  }

  @GetMapping
  public ResponseEntity<List<Farm>> findAll() {
    List<Farm> farms = farmService.findAll();
    return ResponseEntity.ok(
        farms.stream()
            .map((farm -> new FarmDto(farm.getId(), farm.getName(), farm.getSize()).toEntity()))
            .collect(Collectors.toList())
    );
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Farm> findById(@PathVariable Long id) {
    return ResponseEntity.ok(farmService.findById(id));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Farm> update(@PathVariable Long id, @RequestBody FarmDto farmDto) {
    Farm farm = farmService.update(id, farmDto.toEntity());
    return ResponseEntity.ok(farm);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    farmService.delete(id);
    return ResponseEntity.ok(null);
  }

}

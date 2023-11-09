package com.trybe.agrixspringapi.model.repository;

import com.trybe.agrixspringapi.model.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

}

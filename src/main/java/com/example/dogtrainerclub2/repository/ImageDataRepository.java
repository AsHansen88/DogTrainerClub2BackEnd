package com.example.dogtrainerclub2.repository;

import com.example.dogtrainerclub2.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageDataRepository extends JpaRepository<ImageModel, Long> {
Optional<ImageModel> findByName(String name);
}

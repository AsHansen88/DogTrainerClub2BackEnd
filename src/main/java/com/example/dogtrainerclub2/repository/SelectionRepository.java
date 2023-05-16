package com.example.dogtrainerclub2.repository;

import com.example.dogtrainerclub2.model.SelectionModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SelectionRepository extends JpaRepository<SelectionModel, Long> {
}

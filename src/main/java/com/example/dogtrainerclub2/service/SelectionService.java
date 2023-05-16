package com.example.dogtrainerclub2.service;

import com.example.dogtrainerclub2.model.SelectionModel;
import com.example.dogtrainerclub2.repository.SelectionRepository;
import com.example.dogtrainerclub2.service.impl.SelectionService_impl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SelectionService implements SelectionService_impl {

  private SelectionRepository selectionRepository;

  @Override
  public SelectionModel createSelection(SelectionModel selectionModel) {
    return selectionRepository.save(selectionModel);
  }

  @Override
  public SelectionModel getSelectionUserById(Long id) {
    Optional<SelectionModel> optionalSelectionModel = selectionRepository.findById(id);
    return optionalSelectionModel.get();
  }

  @Override
  public List<SelectionModel> getAllSelectionUsers() {
    return selectionRepository.findAll();
  }

  @Override
  public SelectionModel updateSelectionUser(SelectionModel selectionModel) {

    SelectionModel existingSelectionUser = selectionRepository.findById(selectionModel.getId()).get();
    existingSelectionUser.setName(selectionModel.getName());
    existingSelectionUser.setNumber(selectionModel.getNumber());
    existingSelectionUser.setEmail(selectionModel.getEmail());
    SelectionModel updateSelectedUser = selectionRepository.save(existingSelectionUser);
    return updateSelectedUser;
  }

  @Override
  public void deleteSelectionUser(Long id) {
    selectionRepository.deleteById(id);
  }
}

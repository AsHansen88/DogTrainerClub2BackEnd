package com.example.dogtrainerclub2.service.impl;

import com.example.dogtrainerclub2.model.SelectionModel;

import java.util.List;

public interface SelectionService_impl {

  SelectionModel createSelection(SelectionModel selectionModel);

  SelectionModel getSelectionUserById(Long id);

  List<SelectionModel>getAllSelectionUsers();

  SelectionModel updateSelectionUser(SelectionModel selectionModel);

  void deleteSelectionUser(Long id);
}

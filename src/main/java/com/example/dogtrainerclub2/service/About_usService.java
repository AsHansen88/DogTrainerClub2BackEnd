package com.example.dogtrainerclub2.service;

import com.example.dogtrainerclub2.model.About_usModel;
import com.example.dogtrainerclub2.repository.About_usRepository;
import com.example.dogtrainerclub2.service.impl.About_usService_impl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class About_usService implements About_usService_impl {


  private About_usRepository about_usRepository;

  @Override
  public About_usModel createAboutUsModel(About_usModel about_usModel) {
    return about_usRepository.save(about_usModel);
  }

  @Override
  public About_usModel getAboutUsModelById(Long id) {
    Optional<About_usModel> optionalUser = about_usRepository.findById(id);
    return optionalUser.get();
  }

  @Override
  public List<About_usModel> getAllAboutUsModel() {
    return about_usRepository.findAll();
  }

  @Override
  public About_usModel updateAboutUsModel(About_usModel about_usModel) {
    About_usModel existingAboutUsModel = about_usRepository.findById(about_usModel.getId()).get();
    existingAboutUsModel.setFirstname(about_usModel.getFirstname());
    existingAboutUsModel.setLastname(about_usModel.getLastname());
    existingAboutUsModel.setPhonenumber(about_usModel.getPhonenumber());
    existingAboutUsModel.setEmail(about_usModel.getEmail());
    existingAboutUsModel.setPhoto(about_usModel.getPhoto());
    About_usModel updatedAboutUsModel = about_usRepository.save(existingAboutUsModel);
    return updatedAboutUsModel;
  }

  @Override
  public void deleteAboutUsModel(Long id) {
    about_usRepository.deleteById(id);
  }
}



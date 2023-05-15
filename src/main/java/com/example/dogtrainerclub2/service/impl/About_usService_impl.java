package com.example.dogtrainerclub2.service.impl;

import com.example.dogtrainerclub2.model.About_usModel;

import java.util.List;

public interface About_usService_impl {

About_usModel createAboutUsModel(About_usModel about_usModel);

About_usModel getAboutUsModelById(Long id);

List<About_usModel> getAllAboutUsModel();

About_usModel updateAboutUsModel(About_usModel about_usModel);

void deleteAboutUsModel(Long id);
}

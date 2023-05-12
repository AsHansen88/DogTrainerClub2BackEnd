package com.example.dogtrainerclub2.service;

import com.example.dogtrainerclub2.Util.ImageUtil;
import com.example.dogtrainerclub2.exception.ImageUploadResponse;
import com.example.dogtrainerclub2.model.ImageModel;
import com.example.dogtrainerclub2.repository.ImageDataRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataService {

  @Autowired
  private ImageDataRepository imageDataRepository;

  public ImageUploadResponse uploadImage(MultipartFile file) throws IOException {

    imageDataRepository.save(ImageModel.builder()
        .name(file.getOriginalFilename())
        .type(file.getContentType())
        .image_data(ImageUtil.compressImage(file.getBytes())).build());

    return new ImageUploadResponse("Image uploaded successfully: " +
        file.getOriginalFilename());

  }

  @Transactional
  public ImageModel getInfoByImageByName(String name) {
    Optional<ImageModel> dbImage = imageDataRepository.findByName(name);

    return ImageModel.builder()
        .name(dbImage.get().getName())
        .type(dbImage.get().getType())
        .image_data(ImageUtil.decompressImage(dbImage.get().getImage_data())).build();

  }

  @Transactional
  public byte[] getImage(String name) {
    Optional<ImageModel> dbImage = imageDataRepository.findByName(name);
    byte[] image = ImageUtil.decompressImage(dbImage.get().getImage_data());
    return image;
  }

}






package com.example.dogtrainerclub2.model;


import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.Arrays;

@Entity
@Table(name = "image_data")
@Builder
public class ImageModel {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String type;


  @Lob
  @Column(name = "image_data", length = 1000)

  private byte[] imageData;

  public ImageModel(Long id, String name, String type, byte[] imageData) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.imageData = imageData;
  }
/*
public ImageModel(){

}
*/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getImageData() {
    return imageData;
  }

  public void setImageData(byte[] imageData) {
    this.imageData = imageData;
  }

  @Override
  public String toString() {
    return "ImageModel{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", type='" + type + '\'' +
        ", imageData=" + Arrays.toString(imageData) +
        '}';
  }
}

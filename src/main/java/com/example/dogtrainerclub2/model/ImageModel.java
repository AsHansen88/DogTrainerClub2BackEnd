package com.example.dogtrainerclub2.model;



import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


import java.util.Arrays;

@Entity
@Table(name = "image_data")
@Builder
@Data
public class ImageModel {



  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Id
  private String name;
  private String type;


  @Lob
  @Column(name = "image_data", length = 1000)

  private byte[] image_data;

  public ImageModel(Long id, String name, String type, byte[] image_data) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.image_data = image_data;
  }

public ImageModel(){

}

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

  public byte[] getImage_data() {
    return image_data;
  }

  public void setImage_data(byte[] image_data) {
    this.image_data = image_data;
  }

  @Override
  public String toString() {
    return "ImageModel{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", type='" + type + '\'' +
        ", imageData=" + Arrays.toString(image_data) +
        '}';
  }
}

package com.example.dogtrainerclub2.model;

import jakarta.persistence.*;

@Entity
@Table(name = "udvalg")
public class SelectionModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private int number;
  @Column(nullable = false, unique = true)
  private String email;

  public SelectionModel(long id, String name, int number, String email) {
    this.id = id;
    this.name = name;
    this.number = number;
    this.email = email;
  }

  public SelectionModel() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

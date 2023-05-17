package com.example.dogtrainerclub2.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "trailsandawards")
public class TrailsAndAwardsModel {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String title;
  private String body;
  private Date dateCreated;

  public TrailsAndAwardsModel() {

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }
}

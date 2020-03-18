package com.example.BackendApp.models;


public class HotelModel {
  private String name, description;
  private Integer stars;

  public HotelModel(String name, String description, Integer stars) {
    this.name = name;
    this.description = description;
    this.stars = stars;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getStars() {
    return stars;
  }

  public void setStars(Integer stars) {
    this.stars = stars;
  }
}

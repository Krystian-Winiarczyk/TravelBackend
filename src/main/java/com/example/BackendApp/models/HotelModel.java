package com.example.BackendApp.models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelModel {
  private String name;
  private String description;
  private Integer stars;

  public HotelModel(@JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("stars") Integer stars) {
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

  @Override
  public String toString() {
    return "HotelModel{" +
            "name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", stars=" + stars +
            '}';
  }
}

package com.example.BackendApp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class TravelModel {
    @Id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String id;
    private String name, country, description, startDate, endDate, transport;
    private HotelModel hotel;
    private ArrayList<String> atuts, imagesPaths;
    private Integer tripStars, price, personsCount;

  public Integer getPersonsCount() {
    return personsCount;
  }

  public void setPersonsCount(Integer personsCount) {
    this.personsCount = personsCount;
  }

  public TravelModel(String name, String country, String description, String startDate, String endDate, String transport, HotelModel hotel, ArrayList<String> atuts, ArrayList<String> imagesPaths, Integer tripStars, Integer price, Integer personsCount) {
    this.name = name;
    this.country = country;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
    this.transport = transport;
    this.hotel = hotel;
    this.atuts = atuts;
    this.imagesPaths = imagesPaths;
    this.tripStars = tripStars;
    this.price = price;
    this.personsCount = personsCount;
  }

  public HotelModel getHotel() {
    return hotel;
  }

  public void setHotel(HotelModel hotel) {
    this.hotel = hotel;
  }

  public Integer getTripStars() {
    return tripStars;
  }

  public void setTripStars(Integer tripStars) {
    this.tripStars = tripStars;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public ArrayList<String> getAtuts() {
        return atuts;
    }

    public void setAtuts(ArrayList<String> atuts) {
        this.atuts = atuts;
    }

    public ArrayList<String> getImagesPaths() {
        return imagesPaths;
    }

    public void setImagesPaths(ArrayList<String> imagesPaths) {
        this.imagesPaths = imagesPaths;
    }

  @Override
  public String toString() {
    return "TravelModel{" +
      "id='" + id + '\'' +
      ", name='" + name + '\'' +
      ", country='" + country + '\'' +
      ", description='" + description + '\'' +
      ", startDate='" + startDate + '\'' +
      ", endDate='" + endDate + '\'' +
      ", transport='" + transport + '\'' +
      ", hotel=" + hotel +
      ", atuts=" + atuts +
      ", imagesPaths=" + imagesPaths +
      ", tripStars=" + tripStars +
      ", price=" + price +
      '}';
  }
}

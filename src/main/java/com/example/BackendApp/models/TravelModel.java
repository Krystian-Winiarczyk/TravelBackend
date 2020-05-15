package com.example.BackendApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class TravelModel {
    @Id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String id;
    private String name;
    private String country;
    private String description;
    private String startDate;
    private String endDate;
    private String transport;
    private HotelModel hotel;
    private List<String> atuts;
    private Integer tripStars;
    private Integer price;
    private Integer personsCount;
    private ArrayList<String> images;

  public Integer getPersonsCount() {
    return personsCount;
  }

  public void setPersonsCount(Integer personsCount) {
    this.personsCount = personsCount;
  }

  public TravelModel(@JsonProperty("name") String name,
                     @JsonProperty("country") String country,
                     @JsonProperty("description") String description,
                     @JsonProperty("startDate") String startDate,
                     @JsonProperty("endDate") String endDate,
                     @JsonProperty("transport") String transport,
                     @JsonProperty("hotel") HotelModel hotel,
                     @JsonProperty("atuts") List<String> atuts,
                     @JsonProperty("tripStars") Integer tripStars,
                     @JsonProperty("price") Integer price,
                     @JsonProperty("personsCount") Integer personsCount) {
    this.name = name;
    this.country = country;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
    this.transport = transport;
    this.hotel = hotel;
    this.atuts = atuts;
    this.tripStars = tripStars;
    this.price = price;
    this.personsCount = personsCount;
  }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
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

    public List<String> getAtuts() {
        return atuts;
    }

    public void setAtuts(ArrayList<String> atuts) {
        this.atuts = atuts;
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
      ", hotel=" + hotel.toString() +
      ", atuts=" + atuts +
      ", tripStars=" + tripStars +
      ", price=" + price +
      '}';
  }
}

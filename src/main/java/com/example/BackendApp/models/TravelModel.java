package com.example.BackendApp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.ArrayList;

public class TravelModel {
    @Id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String id;
    private String name, country, description, startDate, endDate, hotelName, transport;
    private ArrayList<String> atuts, imagePaths;

    public TravelModel(String name, String country, String description, String startDate, String endDate, String hotelName, String transport, ArrayList<String> atuts, ArrayList<String> imagePaths) {
        this.name = name;
        this.country = country;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hotelName = hotelName;
        this.transport = transport;
        this.atuts = atuts;
        this.imagePaths = imagePaths;
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public ArrayList<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(ArrayList<String> imagePaths) {
        this.imagePaths = imagePaths;
    }
}

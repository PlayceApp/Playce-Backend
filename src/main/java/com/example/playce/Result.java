package com.example.playce;

import java.util.*;

public class Result{

    private final String name;
    private final int price;
    private final double rating;
    private final String address;
    private final String category;
    private final double latitude;
    private final double longitude;
    private double distance;

    public Result(String name, int price, double rating, String address, double latitude, double longitude, String category) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.address = address;
        this.category = category;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public boolean isEqualTo(Result r) {
        return (this.name.equals(r.name)
            && this.price == r.price
            && this.rating == r.rating
            && this.address.equals(r.address)
            && this.category.equals(r.category)
            && this.latitude == r.latitude
            && this.longitude == r.longitude
            && this.distance == r.distance);
    }

    public String getName() {
        return name;
    }
    public void setDistance(double distance){
        this.distance = distance;
    }
    public double getDistance(){
        return distance;
    }
    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }
    public String getAddress() {
        return address;
    }

    public String getCategory() {
        return category;
    }

    public double getLatitude() {
       return latitude;
    }

    public double getLongitude() {
       return longitude;
    }
    
    public int compare(Result r){
        if (r == null){
                return -1;
        }
        return a.getName().compareTo(b.getName());
    }
}

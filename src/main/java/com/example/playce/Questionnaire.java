package com.example.playce;

public class Questionnaire {
    
    private final String price;
    private final String category;
    private final double rating;
    private final double latitude;
    private final double longitude;
    private final String cuisine;

    public Questionnaire() {
        this.price = "";
        this.category = "";
        this.rating = -1;
        this.latitude = -1;
        this.longitude = -1;
        this.cuisine = "";
    }
    public Questionnaire(String price, String category, double rating, double latitude, double longitude, String cuisine) {
        this.price = price;
        this.category = category;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cuisine = cuisine;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCuisine() {
        return cuisine;
    }
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
}

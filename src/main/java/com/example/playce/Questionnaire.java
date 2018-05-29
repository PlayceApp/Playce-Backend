package com.example.playce;

public class Questionnaire {
    
    private final String price;
    private final String category;
    private final double rating;
    private final double latitude;
    private final double longitude;
    private final String cuisine;
    private final String is21;
  
    public Questionnaire(String price, String category, double rating, double latitude, double longitude, String cuisine, String is21) {
        this.price = price;
        this.category = category;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cuisine = cuisine;
        this.is21 = is21;
    }

    public boolean isOver21() {
       return is21.equals("Yes");
    }

    public int getAge() {
       if (is21.equals("Yes")) {
          return 21; 
       }
       return 0;
    }
    
    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCuisine() {
        return cuisine;
    }
}

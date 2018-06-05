package com.example.playce;

public class Questionnaire {
    private String category;
    private String distance;
    private String shouldShowAgeRestricted;
    private String ethnicity;
    private String specialty;
    private String restaurantType;
    private double latitude;
    private double longitude;
    private String activitiesOver21;
    private String price;
    private String useRating;

    public Questionnaire(
          String category,
          String distance,
          String shouldShowAgeRestricted,
          String ethnicity,
          String specialty,
          String restaurantType,
          double latitude,
          double longitude,
          String activitiesOver21,
          String price,
          String useRating) {
        this.category = category;
        this.distance = distance;
        this.shouldShowAgeRestricted = shouldShowAgeRestricted;
        this.activitiesOver21 = activitiesOver21;
        this.restaurantType = restaurantType;
        this.ethnicity = ethnicity;
        this.specialty = specialty;
        this.latitude = latitude;
        this.longitude = longitude;
        this.useRating = useRating;
        this.price = price;
    }

    public String getCategory() {
       return this.category;
    }

    public String getDistance() {
       return this.distance;
    }

    public String getShouldShowAgeRestricted() {
       return this.shouldShowAgeRestricted;
    }

    public String getEthnicity() {
       return this.ethnicity;
    }

    public String getSpecialty() {
       return this.specialty;
    }

    public String getRestaurantType() {
       return this.restaurantType;
    }

    public double getLatitude() {
       return this.latitude;
    }

    public double getLongitude() {
       return this.longitude;
    }

    public String getActivitiesOver21() {
       return this.activitiesOver21;
    }

    public String getPrice() {
       return this.price;
    }

    public String getUseRating() {
       return this.useRating;
    }
}

package com.example.playce;

public class Questionnaire {
    
    private final String price;
    private final String category;
    private final double rating;
//    private final double[] userCoordinates;

    public Questionnaire(String price, String category, double rating) {
        this.price = price;
        this.category = category;
        this.rating = rating;

    //    this.userCoordinates = userCoordinates;
    }

    public String getPrice() {
        return price;
    }

/*
    public double[] getUserCoordinates() {
        return userCoordinates;
    }
*/
    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }
}

package com.example.playce;

public class Questionnaire {
    
    private final int price;
    private final String category;
    private final double[] userCoordinates;

    public Questionnaire(int price, String category, double[] userCoordinates) {
        this.price = price;
        this.category = category;
        this.userCoordinates = userCoordinates;
    }

    public int getPrice() {
        return price;
    }

    public double[] getUserCoordinates() {
        return userCoordinates;
    }

    public String getCategory() {
        return category;
    }
}

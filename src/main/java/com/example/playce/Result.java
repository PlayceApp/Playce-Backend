package com.example.playce;

public class Result {

    private final String name;
    private final int price;
    private final double rating;
    private final String address;
    private final String category;

    public Result(String name, int price, double rating, String address, String category) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.address = address;
        this.category = category;
    }

    public String getName() {
        return name;
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
}

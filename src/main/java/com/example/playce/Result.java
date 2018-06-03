package com.example.playce;

public class Result implements Comparable<Result>{

    private final String name;
    private final int price;
    private final double rating;
    private final String address;
    private final String category;
    private final double latitude;
    private final double longitude;
    private double distance; 

    public Result(String name, int price, double rating, String address, String category, double latitude, double longitude) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.address = address;
        this.category = category;
        this.latitude = latitude;
        this.longitude = longitude;
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
    //implementing a Ccmparetor to sort and overriding the compareTo to compare distances 
    @Override
    public int compareTo(Result o){
        if (this.getDistance() > o.getDistance())
            return 1;
        else if (this.getDistance() == o.getDistance()){
            if (this.getRating() > o.getRating()){
                return -1;
            }else{
                return 1;
            }
        }else{
            return -1;
        }
    }
}

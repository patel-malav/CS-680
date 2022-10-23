package edu.umb.cs680.hw04;

public class Car {
    private String maker, model;
    private int mileage, year;
    private float price;

    Car(String maker, String model, int year, int mileage, float price) {
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getMaker() {
        return this.maker;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getYear() {
        return this.year;
    }

    public float getPrice() {
        return this.price;
    }

    public int getMileage() {
        return this.mileage;
    }
}

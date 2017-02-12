package com.example.piotrekj.shopppingproject;

import java.io.Serializable;


public class Product implements Serializable {
    private String name;
    private String unit;
    private double price;
    private double shopsPrice;
    private int counter;
    private int id;


    public Product(){

    }

    public Product(String name, String unit, double price, double shopsPrice, int id) {
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.shopsPrice = shopsPrice;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getShopsPrice() {
        return shopsPrice;
    }

    public void setShopsPrice(int shopsPrice) {
        this.shopsPrice = shopsPrice;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "name: " + name + ", unit: " + unit + ", price: " + price + ", shopsPrice: " + shopsPrice;
    }
}

package com.pluralsight;

public class Product {

    private int id;
    private String name;
    private float price;
    public Product(int id, float price, String name ) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
public int getId(){
    return this.id;
    }
public String getName(){
    return this.name;
}
public float getPrice() {
    return this.price;
    }
}

package com.example.cardrecycletest;



public class Food {
    public String name;
    public String descr;
    public String price;


    public int img;

    public Food() {
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public Integer getImg() {
        return img;
    }

    public Food(String name, String descr, String price, int img) {
        this.name = name;
        this.descr = descr;
        this.price = price;
        this.img = img;
    }
}

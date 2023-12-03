package com.example.javawebgyak2;

import java.util.ArrayList;

public class Product {
    String name;
    int price;
    String keyword;
    static ArrayList<String> allkeywords;

    static {
        allkeywords = new ArrayList<String>();
        allkeywords.add("ember");
        allkeywords.add("butor");

    }

    String reservedby;

    public Product(String name, int price, String keyword) {
        this.name = name;
        this.price = price;
        this.keyword = keyword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public static ArrayList<String> getAllkeywords() {
        return allkeywords;
    }

    public static void setAllkeywords(ArrayList<String> allkeywords) {
        Product.allkeywords = allkeywords;
    }

    public String getReservedby() {
        return reservedby;
    }

    public void setReservedby(String reservedby) {
        this.reservedby = reservedby;
    }
}

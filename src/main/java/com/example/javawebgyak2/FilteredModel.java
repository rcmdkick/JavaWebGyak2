package com.example.javawebgyak2;

public class FilteredModel {
    Advertiser owner;
    Product product;

    public FilteredModel(Advertiser owner, Product product) {
        this.owner = owner;
        this.product = product;
    }

    public Advertiser getOwner() {
        return owner;
    }

    public Product getProduct() {
        return product;
    }
}

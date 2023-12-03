package com.example.javawebgyak2;

import java.util.ArrayList;

public class Advertiser {
    String email;
    ArrayList<Product> selling;

    public Advertiser(String email) {
        this.email = email;
        selling= new ArrayList<Product>();
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Product> getSelling() {
        return selling;
    }
    public void addProduct(Product p)
    {
        selling.add(p);
    }
    public Product findProduct(String name)
    {
        return selling.stream().filter(p->
                name.equals(p.getName()))
                .findFirst().orElse(null);
    }
    public ArrayList<Product> findProductviaKeyWords(String keyword)
    {
        //return eladnivalo.stream().filter(p-> keyword.equals(p.getName())).collect(Collectors.toCollection());
        ArrayList<Product> prods = new ArrayList<Product>();
        for (Product p: selling) {
            if (p.getKeyword().equals(keyword))
            {
                prods.add(p);
            }
        }
        return prods;
    }
}

package com.example.javawebgyak2;

import java.util.ArrayList;

public class Repository {
    static Repository instance;
    ArrayList<Advertiser> advertisers;

    public ArrayList<Advertiser> getAdvertisers() {
        return advertisers;
    }

    private Repository() {
        advertisers = new ArrayList<Advertiser>();
        Advertiser bela = new Advertiser("a1@t.hu");
        bela.addProduct(new Product("komod",22000,"butor"));
        advertisers.add(bela);
        Advertiser pisti = new Advertiser("a2@t.hu");
        pisti.addProduct(new Product("anyad",22000,"ember"));
        advertisers.add(pisti);

    }

    public static Repository getInstance() {
        if(instance==null)
        {
            instance= new Repository();
        }
        return instance;
    }
    public Advertiser findAdvertiser(String email)
    {
        return advertisers.stream().filter(
                a -> email.equals(a.getEmail()))
                .findFirst().orElse(null);
    }
}

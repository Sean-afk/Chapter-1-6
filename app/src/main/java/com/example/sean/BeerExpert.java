package com.example.sean;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    List<String> getBrands(String beerType){
        List<String> brands = new ArrayList<>();
        if (beerType.equals("Mild")){
            brands.add("Jack amber");
            brands.add("Red moose");
        }else{
            brands.add("Jail Pale Ale");
            brands.add("Gout Scout");
        }
        return brands;


    }
}

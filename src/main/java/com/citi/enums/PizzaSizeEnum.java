package com.citi.enums;

import java.util.ArrayList;
import java.util.List;

public enum PizzaSizeEnum {

    Small("Small"), Medium("Medium"), Large("Large");

    private String name;

    private PizzaSizeEnum(String name) {
        this.name = name;
    }

    public static List<String> getPizzaSizes() {
        List<String> pizzaSizes = new ArrayList<String>();
        for (PizzaSizeEnum pizzaSizeEnum : PizzaSizeEnum.values()) {
            pizzaSizes.add(pizzaSizeEnum.name);
        }
        return pizzaSizes;
    }
}

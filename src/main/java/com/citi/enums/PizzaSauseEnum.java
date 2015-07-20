package com.citi.enums;

import java.util.ArrayList;
import java.util.List;

public enum PizzaSauseEnum {
    Margarita("Margarita"), Mexican_Salsa("Mexican Salsa");

    private String name;

    private PizzaSauseEnum(String name) {
        this.name = name;
    }

    public static List<String> getPizzaBases() {
        List<String> pizzaSauses = new ArrayList<String>();
        for (PizzaSauseEnum pizzaSauseEnum : PizzaSauseEnum.values()) {
            pizzaSauses.add(pizzaSauseEnum.name);
        }
        return pizzaSauses;
    }

    public static Integer getPizzaBasePrize(String name) {
        return 0;
    }

}

package com.citi.enums;

import java.util.ArrayList;
import java.util.List;

public enum PizzaBaseEnum {
    Normal("Normal Crust", 75), Pan_Crust("Pan Crust", 100), Thin_Curst("Thin Crust", 100), Cheesy_Bites("Pan Crust",
            125),

    Small(0), Medium(25), Large(50);

    private String name;
    private Integer price;

    private PizzaBaseEnum(Integer price) {
        this.price = price;
    }

    private PizzaBaseEnum(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static List<String> getPizzaBases() {
        List<String> pizzaBases = new ArrayList<String>();
        for (PizzaBaseEnum pizzaBaseEnum : PizzaBaseEnum.values()) {
            if (pizzaBaseEnum.name != null) {
                pizzaBases.add(pizzaBaseEnum.name);
            }
        }
        return pizzaBases;
    }

    public static Integer getPizzaBasePrize(String name) {
        List<String> pizzaBases = new ArrayList<String>();
        for (PizzaBaseEnum pizzaBaseEnum : PizzaBaseEnum.values()) {
            if (pizzaBaseEnum.name != null && pizzaBaseEnum.name.indexOf(name) != -1) {
                return pizzaBaseEnum.price;
            }
            pizzaBases.add(pizzaBaseEnum.name);
        }
        return -1;
    }

    public static Integer getPizzaSizeIncrement(String name) {
        for (PizzaBaseEnum pizzaBaseEnum : PizzaBaseEnum.values()) {
            if (pizzaBaseEnum.name == null && pizzaBaseEnum.toString().equalsIgnoreCase(name)) {
                return pizzaBaseEnum.price;
            }
        }
        return -1;
    }
}

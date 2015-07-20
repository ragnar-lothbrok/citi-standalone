package com.citi.enums;

import java.util.ArrayList;
import java.util.List;

public enum CheeseTypeEnum {

    Mozzarella("Mozzarella", -1), Cream_Cheese("Cream Cheese", -1),

    Small("Small", 15), Medium("Medium", 30), Large("Large", 45);

    private String toppingName;
    private Integer doubleCheesePrice;

    private CheeseTypeEnum(String name, Integer price) {
        this.toppingName = name;
        this.doubleCheesePrice = price;
    }

    public static List<String> getAvailableToppings() {
        List<String> toppings = new ArrayList<String>();
        for (CheeseTypeEnum toppingsEnum : CheeseTypeEnum.values()) {
            if (toppingsEnum.doubleCheesePrice == -1) {
                toppings.add(toppingsEnum.toppingName);
            }
        }
        return toppings;
    }

    public static Integer getDoubleCheezePrize(String toppingSize) {
        Integer toppingPrice = 0;
        for (CheeseTypeEnum toppingsEnum : CheeseTypeEnum.values()) {
            if (toppingsEnum.doubleCheesePrice != -1 && toppingsEnum.toppingName.equalsIgnoreCase(toppingSize)) {
                toppingPrice = toppingsEnum.doubleCheesePrice;
            }
        }
        return toppingPrice;
    }
}

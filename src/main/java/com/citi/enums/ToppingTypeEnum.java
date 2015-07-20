package com.citi.enums;

import java.util.ArrayList;
import java.util.List;

public enum ToppingTypeEnum {

    Capsicum("Capsicum", -1), Onion("Onion", -1), Tomato("Tomato", -1), Corn("Corn", -1), Baby_Corn("Baby Corn", -1), Jalapeno("Jalapeno", -1), Black_Olive("Black Olive",
            -1), Paneer("", -1), Red_Pepper("", -1),

    Small("Small", 15), Medium("Medium", 30), Large("Large", 45);

    private String toppingName;
    private Integer doubleCheesePrice;

    private ToppingTypeEnum(String name, Integer price) {
        this.toppingName = name;
        this.doubleCheesePrice = price;
    }

    public static List<String> getAvailableToppings() {
        List<String> toppings = new ArrayList<String>();
        for (ToppingTypeEnum toppingsEnum : ToppingTypeEnum.values()) {
            if (toppingsEnum.doubleCheesePrice == -1) {
                toppings.add(toppingsEnum.toppingName);
            }
        }
        return toppings;
    }

    public static Integer getToppingPrize(String toppingSize) {
        Integer toppingPrice = 0;
        for (ToppingTypeEnum toppingsEnum : ToppingTypeEnum.values()) {
            if (toppingsEnum.doubleCheesePrice != -1 && toppingsEnum.toppingName.equalsIgnoreCase(toppingSize)) {
                toppingPrice = toppingsEnum.doubleCheesePrice;
            }
        }
        return toppingPrice;
    }
}

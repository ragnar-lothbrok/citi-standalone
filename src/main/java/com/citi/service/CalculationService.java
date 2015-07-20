package com.citi.service;

import com.citi.model.Receipt;

public abstract class CalculationService {

    protected static final float servicTax = 5f;
    protected static final float vat = 6f;

    public Receipt calculate(String[] orderList) {
        Receipt receipt = null;
        if (orderList != null && orderList.length > 0) {
            for (String order :orderList) {
                receipt = initializeReceipt(order.trim(), receipt);
            }
            calculatePizza(receipt);
            calculateTopping(receipt);
            calculateCheezePrice(receipt);
            calculateServiceTax(receipt);
            calculateVatTax(receipt);
        }
        showReceipt(receipt);
        return receipt;
    }

    protected abstract void calculateCheezePrice(Receipt receipt);

    protected abstract void showReceipt(Receipt receipt);

    protected abstract void calculateVatTax(Receipt receipt);

    protected abstract void calculateServiceTax(Receipt receipt);

    protected abstract void calculateTopping(Receipt receipt);

    protected abstract void calculatePizza(Receipt receipt);

    protected abstract Receipt initializeReceipt(String productDesc, Receipt receipt);

}

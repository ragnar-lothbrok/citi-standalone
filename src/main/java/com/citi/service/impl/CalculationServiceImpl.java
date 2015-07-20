package com.citi.service.impl;

import com.citi.enums.PizzaBaseEnum;
import com.citi.enums.CheeseTypeEnum;
import com.citi.enums.ToppingTypeEnum;
import com.citi.model.Product;
import com.citi.model.Receipt;
import com.citi.service.CalculationService;

public class CalculationServiceImpl extends CalculationService {

    @Override
    protected void showReceipt(Receipt receipt) {
        if (receipt != null) {
            if (receipt.getProductList() != null && receipt.getProductList().size() > 0) {
                for (int i = 0; i < receipt.getProductList().size(); i++) {
                    System.out.println(receipt.getProductList().get(i).getProductDesc() + " : "
                            + receipt.getProductList().get(i).getProductPrice());
                }
            }
            System.out.println("Order Total       : " + receipt.getProductPriceTotal());
            System.out.println("Service Tax (5%)  : " + receipt.getServiceTax());
            System.out.println("VAT (6%)          : " + receipt.getVatAmount());
            System.out.println("Total             : " + receipt.getTotalAmount());
        }
    }

    @Override
    protected Receipt initializeReceipt(String productDesc, Receipt receipt) {
        if (receipt == null) {
            receipt = new Receipt();
        }
        Product product = new Product();
        product.setProductDesc(productDesc);
        product.setContent(productDesc.split("\\|"));
        receipt.getProductList().add(product);
        return receipt;
    }

    @Override
    protected void calculateVatTax(Receipt receipt) {
        receipt.setVatAmount(Math.round(receipt.getProductPriceTotal() * .06));
    }

    @Override
    protected void calculateServiceTax(Receipt receipt) {
        receipt.setServiceTax(Math.round(receipt.getProductPriceTotal() * .05));
    }

    @Override
    protected void calculateTopping(Receipt receipt) {
        if (receipt != null) {
            if (receipt.getProductList() != null && receipt.getProductList().size() > 0) {
                for (int i = 0; i < receipt.getProductList().size(); i++) {
                    float price = 0.0f;
                    String[] cheeze = receipt.getProductList().get(i).getContent()[4].split(",");
                    for (String value : cheeze) {
                        if (value.indexOf("Double") != -1) {
                            price += CheeseTypeEnum
                                    .getDoubleCheezePrize(receipt.getProductList().get(i).getContent()[0]);
                        }
                    }
                    receipt.getProductList().get(i)
                            .setProductPrice(receipt.getProductList().get(i).getProductPrice() + Math.round(price));
                }
            }
        }
    }

    @Override
    protected void calculatePizza(Receipt receipt) {
        if (receipt != null) {
            if (receipt.getProductList() != null && receipt.getProductList().size() > 0) {
                for (int i = 0; i < receipt.getProductList().size(); i++) {
                    float price = PizzaBaseEnum.getPizzaBasePrize(receipt.getProductList().get(i).getContent()[1]);
                    float percentage = PizzaBaseEnum
                            .getPizzaSizeIncrement(receipt.getProductList().get(i).getContent()[0]);
                    price = price + price * (percentage / 100);
                    receipt.getProductList().get(i).setProductPrice((long) Math.round(price));
                }
            }
        }
    }

    @Override
    protected void calculateCheezePrice(Receipt receipt) {
        if (receipt != null) {
            if (receipt.getProductList() != null && receipt.getProductList().size() > 0) {
                for (int i = 0; i < receipt.getProductList().size(); i++) {
                    int length = receipt.getProductList().get(i).getContent()[3].split(",").length;
                    float price = ToppingTypeEnum.getToppingPrize(receipt.getProductList().get(i).getContent()[0]);
                    price = price * length;
                    receipt.getProductList().get(i)
                            .setProductPrice(receipt.getProductList().get(i).getProductPrice() + Math.round(price));
                }
            }
        }
    }

}

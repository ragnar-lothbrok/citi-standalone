package com.citi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Receipt implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Product> productList;
    private Long serviceTax;
    private Long vatAmount;

    public List<Product> getProductList() {
        if (productList == null)
            productList = new ArrayList<Product>();
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Long getProductPriceTotal() {
        Long productPriceTotal = 0l;
        if (productList != null && productList.size() > 0) {
            for (int i = 0; i < productList.size(); i++) {
                productPriceTotal += productList.get(i).getProductPrice();
            }
        }
        return productPriceTotal;
    }

    public Long getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(Long serviceTax) {
        this.serviceTax = serviceTax;
    }

    public Long getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Long vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Long getTotalAmount() {
        return (long) Math.round(getProductPriceTotal() + vatAmount + serviceTax);
    }
}

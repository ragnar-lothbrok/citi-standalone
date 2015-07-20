package com.citi.model;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    private String productDesc;
    private String[] content;
    private Long productPrice;

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public Product() {
    }

    public Product(String productDesc, Long productPrice) {
        super();
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        if (productDesc.length() > 0) {
            this.content = productDesc.trim().split("\\|");
        }
    }

    public String[] getContent() {
        return content;
    }

}

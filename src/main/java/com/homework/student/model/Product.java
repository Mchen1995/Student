package com.homework.student.model;

/**
 * 商品
 */
public class Product {
    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private double price;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
}

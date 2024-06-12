package com.homework.student.model;

/**
 * 商品
 */
public class Product {
    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

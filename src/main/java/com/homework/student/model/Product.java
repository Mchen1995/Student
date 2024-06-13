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
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }
}

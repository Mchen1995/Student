package com.homework.student.service.impl;

import com.homework.student.model.Product;
import ch.qos.logback.core.util.StringUtil;
import com.homework.student.service.ProductManageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("productManageService")
public class ProductManageServiceImpl implements ProductManageService {

    /**
     * 初始化商品
     */
    public static final List<Product> PRODUCT_LIST = new ArrayList<>();
    static {
        PRODUCT_LIST.add(new Product("苹果", "3.00"));
        PRODUCT_LIST.add(new Product("香蕉", "7.00"));
        PRODUCT_LIST.add(new Product("橘子", "15.00"));
    }

    @Override
    public List<Product> queryProduct(String productName, String price) {
        if (StringUtil.isNullOrEmpty(productName) && StringUtil.isNullOrEmpty(price)) {
            return PRODUCT_LIST;
        }
        if (StringUtil.isNullOrEmpty(price)) {
            return PRODUCT_LIST.stream()
                    .filter(product -> product.getName().equals(productName)).collect(Collectors.toList());
        } else {
            if (StringUtil.isNullOrEmpty(productName)) {
                return PRODUCT_LIST.stream()
                        .filter(product -> String.valueOf(product.getPrice()).equals(price)).collect(Collectors.toList());
            } else {
                return PRODUCT_LIST.stream()
                        .filter(product -> String.valueOf(product.getPrice()).equals(price) && product.getName().equals(productName)).collect(Collectors.toList());
            }
        }
    }

    @Override
    public boolean insertProduct(String productName, String price) throws Exception {
        boolean anyMatch = PRODUCT_LIST.stream().anyMatch(product -> product.getName().equals(productName));
        if (anyMatch) {
            throw new Exception("商品"+productName+"已存在");
        } else {
            PRODUCT_LIST.add(new Product(productName, price));
            return true;
        }
    }

    @Override
    public boolean modifyProduct(String productName, String price) throws Exception {
        int index = 0;
        for (int i = 0; i<PRODUCT_LIST.size(); i++) {
            if (PRODUCT_LIST.get(i).getName().equals(productName)) {
                index = i;
            }
        }
        PRODUCT_LIST.get(index).setPrice(price);
        return true;
    }

    @Override
    public boolean deleteProduct(String productName) {
        int index = 0;
        for (int i = 0; i<PRODUCT_LIST.size(); i++) {
            if (PRODUCT_LIST.get(i).getName().equals(productName)) {
                index = i;
            }
        }
        PRODUCT_LIST.remove(index);
        return true;
    }
}

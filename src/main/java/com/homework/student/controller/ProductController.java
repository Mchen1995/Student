package com.homework.student.controller;

import ch.qos.logback.core.util.StringUtil;
import com.homework.student.model.Product;
import com.homework.student.service.ProductManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductManageService productManageService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = productManageService.queryProduct("", "");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/query")
    public ResponseEntity<List<Product>> queryProduct(@RequestParam String productName, @RequestParam String price) {
        List<Product> products = productManageService.queryProduct(productName, price);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addProduct(@RequestParam String productName, @RequestParam String price) throws Exception {
        if (StringUtil.isNullOrEmpty(productName) || StringUtil.isNullOrEmpty(price)) {
            throw new Exception("商品名称或价格不能为空");
        }
        productManageService.insertProduct(productName, price);
    }

    @PostMapping("/modify")
    public void modifyProduct(@RequestParam String productName, @RequestParam String price) throws Exception {
        productManageService.modifyProduct(productName, price);
    }

    @DeleteMapping("/delete/{productName}")
    public void deleteProduct(@PathVariable String productName) throws Exception {
        productManageService.deleteProduct(productName);
    }
}

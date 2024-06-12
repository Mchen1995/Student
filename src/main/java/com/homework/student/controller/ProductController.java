package com.homework.student.controller;

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
        List<Product> products = productManageService.queryProduct("");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addProduct(@RequestParam String productName, @RequestParam double price) throws Exception {
        productManageService.insertProduct(productName, price);
    }
}

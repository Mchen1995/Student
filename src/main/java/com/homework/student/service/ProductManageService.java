package com.homework.student.service;

import com.homework.student.model.Product;

import java.util.List;

/**
 * 商品管理服务接口
 */
public interface ProductManageService {

    /**
     * 根据名称查询
     * @param productName 商品名称
     * @return
     */
    List<Product> queryProduct(String productName);

    /**
     * 新增商品
     * @param productName
     * @param price
     * @return
     */
    boolean insertProduct(String productName, double price) throws Exception;

    /**
     * 修改商品
     * @param productName
     * @param price
     * @return
     */
    boolean modifyProduct(String productName, double price) throws Exception;

    /**
     * 删除商品
     * @param productName
     * @return
     */
    boolean deleteProduct(String productName);
}

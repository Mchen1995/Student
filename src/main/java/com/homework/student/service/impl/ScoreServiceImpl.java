package com.homework.student.service.impl;

import ch.qos.logback.core.util.StringUtil;
import com.homework.student.model.Product;
import com.homework.student.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

    /**
     * 初始化商品
     */
    public static final List<Product> SCORE_LIST = new ArrayList<>();
    static {
        SCORE_LIST.add(new Product("张三", "12.01"));
        SCORE_LIST.add(new Product("李四", "11.70"));
        SCORE_LIST.add(new Product("王五", "9.58"));
        SCORE_LIST.add(new Product("赵六", "10.66"));
        SCORE_LIST.add(new Product("苏七", "11.28"));
    }

    @Override
    public List<Product> queryScore(String name, String score) {
        if (StringUtil.isNullOrEmpty(name) && StringUtil.isNullOrEmpty(score)) {
            return SCORE_LIST;
        }
        if (StringUtil.isNullOrEmpty(score)) {
            return SCORE_LIST.stream()
                    .filter(product -> product.getName().equals(name)).collect(Collectors.toList());
        } else {
            if (StringUtil.isNullOrEmpty(name)) {
                return SCORE_LIST.stream()
                        .filter(product -> String.valueOf(product.getPrice()).equals(score)).collect(Collectors.toList());
            } else {
                return SCORE_LIST.stream()
                        .filter(product -> String.valueOf(product.getPrice()).equals(score) && product.getName().equals(name)).collect(Collectors.toList());
            }
        }
    }

    @Override
    public boolean insertScore(String name, String score) throws Exception {
        boolean anyMatch = SCORE_LIST.stream().anyMatch(product -> product.getName().equals(name));
        if (anyMatch) {
            throw new Exception("学生"+name+"成绩已存在");
        } else {
            SCORE_LIST.add(new Product(name, score));
            return true;
        }
    }

    @Override
    public boolean modifyScore(String name, String score) throws Exception {
        int index = 0;
        for (int i = 0; i<SCORE_LIST.size(); i++) {
            if (SCORE_LIST.get(i).getName().equals(name)) {
                index = i;
            }
        }
        SCORE_LIST.get(index).setPrice(score);
        return true;
    }

    @Override
    public boolean deleteScore(String name) {
        int index = 0;
        for (int i = 0; i<SCORE_LIST.size(); i++) {
            if (SCORE_LIST.get(i).getName().equals(name)) {
                index = i;
            }
        }
        SCORE_LIST.remove(index);
        return true;
    }
}

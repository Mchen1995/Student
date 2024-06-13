package com.homework.student.service;

import com.homework.student.model.Product;

import java.util.List;

public interface ScoreService {

    List<Product> queryScore(String name, String score);

    boolean insertScore(String name, String score) throws Exception;

    boolean modifyScore(String name, String score) throws Exception;

    boolean deleteScore(String name);
}

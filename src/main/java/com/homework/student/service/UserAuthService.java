package com.homework.student.service;

/**
 * 用户鉴权服务
 */
public interface UserAuthService {
    /**
     * 注册服务
     * @param name 用户名
     * @param password 密码
     * @return true-注册成功
     * @throws Exception 异常
     */
    boolean register(String name, String password) throws Exception;

    /**
     * 登录
     * @param name 用户名
     * @param password 密码
     * @return 是否登录成功
     */
    boolean login(String name, String password) throws Exception;
}

package com.homework.student.service.impl;

import com.homework.student.service.UserAuthService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("registerService")
public class UserAuthServiceImpl implements UserAuthService {

    /**
     * 用户表，先保存在内存中，后续可优化为保存在数据库中
     */
    public static final Map<String, String> USER_MAP = new HashMap<>();
    @Override
    public boolean register(String name, String password) throws Exception {
        // 检查用户名是否存在，若存在，则报错，不存在则注册成功
        if (USER_MAP.containsKey(name)) {
            throw new Exception("用户名 "+name+" 已存在！");
        } else {
            USER_MAP.put(name, password);
            return true;
        }
    }

    @Override
    public boolean login(String name, String password) throws Exception {
        if (!USER_MAP.containsKey(name) || !USER_MAP.get(name).equals(password)) {
            throw new Exception("用户名或密码错误");
        }
        return true;
    }
}

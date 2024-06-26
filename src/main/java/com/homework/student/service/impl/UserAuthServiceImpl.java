package com.homework.student.service.impl;

import com.homework.student.service.UserAuthService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("registerService")
public class UserAuthServiceImpl implements UserAuthService {
    public static final String LOGIN_FLAG = "isLogin";

    public static final Map<String, Boolean> LOGIN_MAP = new HashMap<>();

    /**
     * 用户表，先保存在内存中，后续可优化为保存在数据库中
     */
    public static final Map<String, String> USER_MAP = new HashMap<>();
    static {
        USER_MAP.put("admin", "admin");
    }
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
        LOGIN_MAP.put(LOGIN_FLAG, true);
        return true;
    }
}

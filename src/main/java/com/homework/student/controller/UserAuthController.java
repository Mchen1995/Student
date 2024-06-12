package com.homework.student.controller;

import ch.qos.logback.core.util.StringUtil;
import com.homework.student.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户鉴权接口
 */
@RestController
@RequestMapping("/auth")
public class UserAuthController {
    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/register")
    public void register(@RequestParam String name, @RequestParam String password) throws Exception {
        if (StringUtil.isNullOrEmpty(name) || StringUtil.isNullOrEmpty(password)) {
            throw new Exception("用户名或密码不能为空");
        }
        boolean registerSuccess = userAuthService.register(name, password);
    }

    @PostMapping("/login")
    public void login(@RequestParam String name, @RequestParam String password) throws Exception {
        if (StringUtil.isNullOrEmpty(name) || StringUtil.isNullOrEmpty(password)) {
            throw new Exception("用户名或密码不能为空");
        }
        boolean registerSuccess = userAuthService.login(name, password);
    }
}

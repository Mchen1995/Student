package com.homework.student.controller;

import ch.qos.logback.core.util.StringUtil;
import com.homework.student.model.LoginResponse;
import com.homework.student.model.RegisterResponse;
import com.homework.student.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<RegisterResponse> register(@RequestParam String name, @RequestParam String password) throws Exception {
        if (StringUtil.isNullOrEmpty(name) || StringUtil.isNullOrEmpty(password)) {
            return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(false));
        }
        boolean registerSuccess = userAuthService.register(name, password);
        if (registerSuccess) {
            return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(true));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new RegisterResponse(false));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestParam String name, @RequestParam String password) throws Exception {
        if (StringUtil.isNullOrEmpty(name) || StringUtil.isNullOrEmpty(password)) {
            return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse(false));
        }
        boolean registerSuccess = userAuthService.login(name, password);
        if (registerSuccess) {
            return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse(true));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse(false));
        }
    }
}

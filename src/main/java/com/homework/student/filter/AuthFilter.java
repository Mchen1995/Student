package com.homework.student.filter;

import com.homework.student.service.impl.UserAuthServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.homework.student.service.impl.UserAuthServiceImpl.LOGIN_FLAG;

public class AuthFilter implements Filter {
    // 白名单
    private static final Set<String> WHITE_LIST
            = new HashSet<>(Arrays.asList("/auth/login", "/auth/register", "/login_college.html", "/login.html", "/college.jpeg", "sports.jpeg"));

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();

        // 检查请求路径是否在白名单中
        if (WHITE_LIST.contains(httpRequest.getRequestURI())) {
            // 如果在白名单中,则放行
            chain.doFilter(request, response);
            return;
        }

        // 检查用户是否登录 session.getAttribute("userId") == null
        Boolean isLogin = UserAuthServiceImpl.LOGIN_MAP.get(LOGIN_FLAG);
        if (isLogin == null || !isLogin) {
            // 如果用户未登录,则返回一个 JSON 格式的错误响应
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"error\":\"Please login first.\"}");
            return;
        }

        // 如果用户已登录,则继续执行下一个 Filter 或 Controller
        chain.doFilter(request, response);
    }
}

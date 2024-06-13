package com.homework.student.config;

import com.homework.student.filter.AuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<AuthFilter> authFilter() {
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AuthFilter());
        registrationBean.addUrlPatterns("/*"); // 设置需要拦截的 URL 匹配规则
        registrationBean.setName("authFilter");
        registrationBean.setOrder(1); // 设置 Filter 的执行顺序
        return registrationBean;
    }
}

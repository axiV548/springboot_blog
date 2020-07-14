package com.axiv548.springbootblog.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @date 2020/7/4 22:38
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
        .addPathPatterns("/admin/**")
        .excludePathPatterns("/admin")
        .excludePathPatterns("/admin/login");

    }
}

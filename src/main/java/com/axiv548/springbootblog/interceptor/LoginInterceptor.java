package com.axiv548.springbootblog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginInterceptor
 *
 * @date 2020/7/4 22:35
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getSession().getAttribute("user") == null){
            response.sendRedirect("/admin");
//            System.out.println("未登录");
            return false;
        }
//        System.out.println("登录");
        return true;
    }
}

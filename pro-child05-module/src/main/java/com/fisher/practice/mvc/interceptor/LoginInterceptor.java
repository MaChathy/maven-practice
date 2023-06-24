package com.fisher.practice.mvc.interceptor;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器类
 * @author fisher
 * @version 1.0.1 2023/6/24 - 14:02
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {

        // 假设：请求参数中携带 token，且 token 值为 login 表示已登录
        // 1、获取请求参数
        String token = request.getParameter("token");
        // 2、检查 token 值
        if ("login".equals(token)) {
            // 3、对已经登录的请求执行放行操作
            return true;
        }
        // 4、对没有登录的请求跳转到错误信息提示页面
        // ①将提示消息存入请求域
        request.setAttribute("message","私密资源需要登陆后才可以访问");
        //②执行转发
        request.getRequestDispatcher("/feature/system/message").forward(request,response);

        // 5、拦截器不放行，停止执行后续操作
        return false;
    }
}

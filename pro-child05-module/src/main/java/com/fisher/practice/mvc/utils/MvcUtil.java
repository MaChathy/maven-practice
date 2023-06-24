package com.fisher.practice.mvc.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * mvc 工具类
 * @author fisher
 * @version 1.0.1 2023/6/24 - 13:32
 */
public class MvcUtil {

    /**
     * 判断当前请求是否为Ajax请求
     * @param request type:<code>HttpServletRequest</code> 请求对象
     * @return true：当前请求是Ajax请求<br> false：当前请求不是Ajax请求
     */
    public static boolean judgeRequestType(HttpServletRequest request){
        // 获取请求标头
        String acceptHeader = String.valueOf(request.getHeaders("Accept"));
        String xRequestHeader = String.valueOf(request.getHeader("X-Requested-With"));
        // 判断
        return (acceptHeader != null && acceptHeader.contains("application/json"))
                ||
                (xRequestHeader != null && "XMLHttpRequest".equals(xRequestHeader));
    }
}

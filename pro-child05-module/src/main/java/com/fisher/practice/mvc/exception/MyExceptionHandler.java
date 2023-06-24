package com.fisher.practice.mvc.exception;

import com.fisher.practice.mvc.utils.MvcUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 异常处理器类<br>
 * 异常处理器类需要使用 <code>@ControllerAdvice</code> 注解标记
 * @author fisher
 * @version 1.0.1 2023/6/24 - 13:13
 */
@ControllerAdvice
public class MyExceptionHandler {

    /**
     * <code>@ExceptionHandler</code> 标记异常处理方法
     * @param e type:Exception SpringMVC 捕获到的异常对象
     * @param model model
     * @return 逻辑视图名称
     */
    @ExceptionHandler(value = NullPointerException.class)
    public String resolveNullPointerException(Exception e, Model model){
        return "error-nullPointer";
    }

    /**
     * 兼容普通请求和ajax请求的两种请求的处理方法<br>
     * @param e type:<code>Exception</code>
     * @param request type:<code>HttpServletRequest</code>
     * @param response type:<code>HttpServletResponse</code>
     * @return <code>null</code>(字符串作为响应体) 或 逻辑视图名称
     * @throws IOException type:<code>IOException</code>
     */
    @ExceptionHandler(value = Exception.class)
    public String resolveException(Exception e, HttpServletRequest request, HttpServletResponse response) throws IOException {

        //判断当前请求是否是ajax请求
        boolean judgeResult = MvcUtil.judgeRequestType(request);

        if(judgeResult){
            // 对ajax请求返回字符串作为响应体
            String message = e.getMessage();

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(message);

            return null;
        }
        //对普通请求返回逻辑视图名称
        return "error-exception";
    }
}

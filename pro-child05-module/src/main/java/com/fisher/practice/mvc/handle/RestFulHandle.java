package com.fisher.practice.mvc.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * REST-ful 四种请求方式映射
 * <br>使用<code>HiddenHttpMethodFilter</code>将POST请求转化为DELETE或PUT请求
 * @author <a href="https://github.com/MaChathy/maven-practice">fisher</a>
 * @version 1.0.1 2023/6/15 - 13:50
 */
@Slf4j
@Controller
public class RestFulHandle {

    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    public String transformToPut(
            @RequestParam(value = "_method") String method,
            Model model){

        model.addAttribute("method", method);
        log.debug("执行 transformToPut()方法");

        return "REST-target";
    }

    @RequestMapping(value = "/emp/delete",method = RequestMethod.DELETE)
    public String transformToDelete(
            @RequestParam(value = "_method") String method,
            Model model){

        model.addAttribute("method", method);
        log.debug("执行 transformToDelete()方法");

        return "REST-target";
    }

}

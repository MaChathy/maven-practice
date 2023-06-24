package com.fisher.practice.mvc.handle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * handle类
 * @author fisher
 * @version 1.0.1 2023/6/24 - 13:50
 */
@Controller
public class InterceptorDemoHandle {

    @RequestMapping(value = "/portal")
    public String portal(){
        return "filter-portal";
    }

    @RequestMapping(value = "/public/resources")
    public String publicResource(){
        return "public-res";
    }

    @RequestMapping(value = "/private/resources/{path}")
    public String privateResource(
            @PathVariable String path
    ){

        return "private-"+path;

    }

}

package com.fisher.practice.mvc.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring-mvc hello world
 * @author fisher
 * @version 1.0.1 2023/6/13 - 18:43
 */
@Slf4j
@Controller
public class Demo01HelloHandle {

    @RequestMapping("/")
    public String showPortal(){
        return "portal";
    }

    @RequestMapping("say/hello/to/spring/mvc")
    public String sayHello(){
        log.debug("hello world.");
        return "target";
    }

}

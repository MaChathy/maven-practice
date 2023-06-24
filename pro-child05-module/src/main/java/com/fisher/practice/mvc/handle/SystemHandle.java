package com.fisher.practice.mvc.handle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fisher
 * @version 1.0.1 2023/6/24 - 13:58
 */
@Controller
public class SystemHandle {

    @RequestMapping(value = "/feature/system/message")
    public String toSystemMessagePath(){
        return "system-message";
    }
}

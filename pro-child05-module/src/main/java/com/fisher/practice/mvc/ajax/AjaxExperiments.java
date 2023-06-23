package com.fisher.practice.mvc.ajax;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author fisher
 * @version 1.0.1 2023/6/15 - 18:41
 */
@Slf4j
@Controller
public class AjaxExperiments {

    @ResponseBody
    @RequestMapping("/ajax/experiment/One")
    public String experiment01(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "password") String password){

        log.debug("userName: " + userName);
        log.debug("password: " + password);

        return "this message from handler as response[来自服务器]";
    }

}

package com.fisher.practice.mvc.ajax;

import com.fisher.practice.mvc.entry.stu.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author fisher
 * @version 1.0.1 2023/6/15 - 18:41
 */
@Slf4j
@Controller
public class AjaxExperiments {

    @ResponseBody
    @RequestMapping(value = "/ajax/experiment/One")
    public String experiment01(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "password") String password){

        log.debug("userName: " + userName);
        log.debug("password: " + password);

        return "this message from handler as response[来自服务器]";
    }

    @ResponseBody
    @RequestMapping(value = "/ajax/experiment/Two")
    public String experiment02(
            @RequestBody Student student
            ){

        log.debug(student.toString());
        return "this message from handler as response[来自服务器]";
    }

}

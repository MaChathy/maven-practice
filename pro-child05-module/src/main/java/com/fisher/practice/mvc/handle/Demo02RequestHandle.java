package com.fisher.practice.mvc.handle;

import com.fisher.practice.mvc.entry.stu.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fisher
 * @version 1.0.1 2023/6/14 - 12:47
 */
@Slf4j
@Component
@RequestMapping(value = "/demo02")
public class Demo02RequestHandle {

    @RequestMapping(value = "/param/form")
    public String handleFormPost(Student student){
        log.debug(student.toString());

        return "demo02Request";
    }

}

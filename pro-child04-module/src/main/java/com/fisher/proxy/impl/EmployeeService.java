package com.fisher.proxy.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author fisher
 * @version 1.0.1 2023/6/11 - 18:15
 */
@Slf4j
@Component
public class EmployeeService {

    public String getEmployees(){
        log.debug("方法内部 com.fisher.proxy.impl.EmployServices.getEmployees");
        return "some employees";
    }
}

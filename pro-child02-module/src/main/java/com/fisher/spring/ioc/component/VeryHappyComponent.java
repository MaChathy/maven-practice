package com.fisher.spring.ioc.component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * IoC组件，包含其他IoC组件
 * @author fisher
 * @version 1.0.1 2023/6/4 - 19:33
 */
@Getter
@Setter
@Slf4j
public class VeryHappyComponent {

    private HappyMachine happyMachine;

    public void doWork() {
        log.debug("Very happy component do work...using "+happyMachine.getHappyMachineName());
    }

}

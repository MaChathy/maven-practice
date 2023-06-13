package com.fisher.mybatis;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;


/**
 * 使用日志测试
 * @author fisher
 * @version 1.0.1 2023/6/1 - 19:24
 */
public class LogTest {
    private Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog(){
        logger.info(""+LocalDate.now().toString());
        logger.trace("what is trace ?");
        logger.warn("WARNING...");
        logger.debug("this is debugging...");
        logger.error("there are some errors...");
    }
}
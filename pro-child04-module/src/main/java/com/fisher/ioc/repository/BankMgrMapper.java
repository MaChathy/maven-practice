package com.fisher.ioc.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * 持久化层
 * @author fisher
 * @version 1.0.1 2023/6/6 - 14:59
 */
@Repository("bankMgrMapper")
@Slf4j
public class BankMgrMapper {

    public void getMessages(){
        log.debug("I am in DAO...");
    }
}

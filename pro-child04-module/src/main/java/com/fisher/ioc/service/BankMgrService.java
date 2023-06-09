package com.fisher.ioc.service;

import com.fisher.ioc.repository.BankMgrMapper;
import org.springframework.stereotype.Service;

/**
 * the service of bankMgr
 * @author fisher
 * @version 1.0.1 2023/6/6 - 14:59
 */
@Service(value = "bankMgrService")
public class BankMgrService {

    private final BankMgrMapper bankMgrMapper;

    public BankMgrService(BankMgrMapper bankMgrMapper) {
        this.bankMgrMapper = bankMgrMapper;
    }

    public void getMessages(){
        bankMgrMapper.getMessages();
    }
}

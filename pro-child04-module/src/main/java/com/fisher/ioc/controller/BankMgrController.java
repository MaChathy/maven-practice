package com.fisher.ioc.controller;

import com.fisher.ioc.service.BankMgrService;
import org.springframework.stereotype.Controller;

/**
 * the controller of bankMgr
 * @author fisher
 * @version 1.0.1 2023/6/6 - 14:56
 */
@Controller(value = "bankMgrController")
public class BankMgrController {

    private final BankMgrService bankMgrService;

    public BankMgrController(BankMgrService bankMgrService) {
        this.bankMgrService = bankMgrService;
    }

    public void getMessages(){
        bankMgrService.getMessages();
    }
}

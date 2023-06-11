package com.fisher.proxy.api;

import org.springframework.stereotype.Service;

/**
 * 动态代理测试类
 * @author fisher
 * @version 1.0.1 2023/6/10 - 15:26
 */
public interface SoldierService {

    int saveSoldier(String soldierName);

    int removeSoldier(Integer soldierId);

    int updateSoldier(Integer soldierId, String soldierName);

    String getSoldierNameById(Integer soldierId);

}

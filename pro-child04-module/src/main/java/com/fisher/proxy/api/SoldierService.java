package com.fisher.proxy.api;

import org.springframework.stereotype.Service;

/**
 * 动态代理测试类
 * @author fisher
 * @version 1.0.1 2023/6/10 - 15:26
 */
public interface SoldierService {

    /**
     * 保存指定士兵名信息
     * @param soldierName 士兵名
     * @return 影响行数
     */
    int saveSoldier(String soldierName);

    /**
     * 删除指定编号信息
     * @param soldierId 指定编号
     * @return 影响行数
     */
    int removeSoldier(Integer soldierId);

    /**
     * 更新相关信息
     * @param soldierId 指定编号
     * @param soldierName 指定姓名
     * @return 影响行数
     */
    int updateSoldier(Integer soldierId, String soldierName);

    /**
     * 获取指定编号信息
     * @param soldierId 指定编号
     * @return 姓名
     */
    String getSoldierNameById(Integer soldierId);

}

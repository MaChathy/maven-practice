package com.fisher.practice02.ssm.service.api;

import com.fisher.practice02.ssm.entry.Soldier;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * SoldierService 接口<br>
 * 基本CRUD功能
 * @author fisher
 * @version 1.0.1 2023/6/24 - 19:28
 */
public interface SoldierService {
    /** show all soldier info */
    List<Soldier> getAllSoldiers();

    /** select one info by soldierId*/
    Soldier getSoldierById(Integer soldierId);

    /** create a soldier info */
    void addSoldier(Soldier soldier);

    PageInfo<Soldier> getPageInfo(Integer pageNo);

    /** update soldier info */
    void updateSoldier(Soldier soldier);

    /** remove a soldier info */
    void removeSoldier(Integer soldierId);
}

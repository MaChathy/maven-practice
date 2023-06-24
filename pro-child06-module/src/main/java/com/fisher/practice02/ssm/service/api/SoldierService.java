package com.fisher.practice02.ssm.service.api;

import com.fisher.practice02.ssm.entry.Soldier;

import java.util.List;

/**
 * SoldierService 接口
 * @author fisher
 * @version 1.0.1 2023/6/24 - 19:28
 */
public interface SoldierService {

    List<Soldier> getAllSoldiers();

}

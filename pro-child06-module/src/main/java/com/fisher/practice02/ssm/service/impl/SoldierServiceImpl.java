package com.fisher.practice02.ssm.service.impl;

import com.fisher.practice02.ssm.entry.Soldier;
import com.fisher.practice02.ssm.mapper.SoldierMapper;
import com.fisher.practice02.ssm.service.api.SoldierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * SoldierService 接口实现类
 * @author fisher
 * @version 1.0.1 2023/6/24 - 19:29
 */
@Service
@Transactional(readOnly = true)
public class SoldierServiceImpl implements SoldierService {

    private final SoldierMapper soldierMapper;

    public SoldierServiceImpl(SoldierMapper soldierMapper) {
        this.soldierMapper = soldierMapper;
    }


    @Override
    public List<Soldier> getAllSoldiers() {
        return soldierMapper.selectAll();
    }

    @Override
    public void addSoldier(Soldier soldier) {
        soldierMapper.insertOneSoldier(soldier.getSoldierName(),soldier.getSoldierWeapon());
    }

    @Override
    public void updateSoldier(Soldier soldier) {
        soldierMapper.updateOneSoldier(soldier.getSoldierName(),soldier.getSoldierWeapon(), soldier.getSoldierId());
    }

    @Override
    public void removeSoldier(Integer soldierId) {
        soldierMapper.removeOneSoldier(soldierId);
    }

}

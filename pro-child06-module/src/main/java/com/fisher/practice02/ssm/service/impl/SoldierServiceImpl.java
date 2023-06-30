package com.fisher.practice02.ssm.service.impl;

import com.fisher.practice02.ssm.entry.Soldier;
import com.fisher.practice02.ssm.mapper.SoldierMapper;
import com.fisher.practice02.ssm.service.api.SoldierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * SoldierService 接口实现类
 * @author fisher
 * @version 1.0.1 2023/6/24 - 19:29
 */
@Slf4j
@Service("soldierServiceImpl")
public class SoldierServiceImpl implements SoldierService {

    private final SoldierMapper soldierMapper;

    public SoldierServiceImpl(SoldierMapper soldierMapper) {
        this.soldierMapper = soldierMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Soldier> getAllSoldiers() {
        return soldierMapper.selectAll();
    }

    @Override
    public Soldier getSoldierById(Integer soldierId) {
        Soldier soldier = soldierMapper.selectSoldierById(soldierId);
        if (soldier == null){
            throw new RuntimeException("not found soldier");
        }
        return soldier;
    }

    @Override
    public void addSoldier(Soldier soldier) {
        soldier.setSoldierId(soldierMapper.getLastInsertedId());
        soldierMapper.insertOneSoldier(soldier);
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo<Soldier> getPageInfo(Integer pageNo) {
        // 1、设置一页大小
        int pageSize = 3;
        // 2、设定分页数据：开启分页功能。开启后，后面执行的 SELECT 语句会自动被附加 LIMIT 子句，
        // 而且会自动查询总记录数
        PageHelper.startPage(pageNo,pageSize);

        // 3、正常执行查询
        List<Soldier> soldiers = soldierMapper.selectAll();

        // 4、封装为 PageInfo 对象返回
        return new PageInfo<>(soldiers);
    }

    @Override
    public void updateSoldier(Soldier soldier) {
        soldierMapper.updateOneSoldier(soldier.getSoldierName(),soldier.getSoldierWeapon(), soldier.getSoldierId());
    }

    @Override
    public void removeSoldier(Integer soldierId) {
        soldierMapper.deleteOneSoldier(soldierId);
    }

}

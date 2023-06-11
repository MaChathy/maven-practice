package com.fisher.proxy.impl;

import com.fisher.proxy.api.SoldierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * SoldierService 实现类
 * @author fisher
 * @version 1.0.1 2023/6/10 - 15:27
 */
@Slf4j
@Service(value = "outDeclarePointCut")
public class SoldierServiceImpl implements SoldierService {
    @Override
    public int saveSoldier(String soldierName) {

        log.debug("核心业务逻辑：保存到数据库……");

        return 1;
    }

    @Override
    public int removeSoldier(Integer soldierId) {

        log.debug("核心业务逻辑：从数据库删除……");

        return 1;
    }

    @Override
    public int updateSoldier(Integer soldierId, String soldierName) {

        log.debug("核心业务逻辑：更新……");

        return 1;
    }

    @Override
    public String getSoldierNameById(Integer soldierId) {

        log.debug("核心业务逻辑：查询数据库……");

        return "good";
    }

}

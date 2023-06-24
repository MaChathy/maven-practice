package com.fisher.practice02.ssm.mapper;

import com.fisher.practice02.ssm.entry.Soldier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Soldier实体类对应的mapper接口
 * @author fisher
 * @version 1.0.1 2023/6/24 - 18:58
 */
@Repository
public interface SoldierMapper {

    List<Soldier> selectAll();

}

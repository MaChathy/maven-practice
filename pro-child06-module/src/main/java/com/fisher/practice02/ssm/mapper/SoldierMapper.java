package com.fisher.practice02.ssm.mapper;

import com.fisher.practice02.ssm.entry.Soldier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Soldier实体类对应的mapper接口
 * @author fisher
 * @version 1.0.1 2023/6/24 - 18:58
 */
public interface SoldierMapper {

    /** show all soldier info */
    List<Soldier> selectAll();

    /** create a soldier info */
    void insertOneSoldier(
            @Param("soldierName") String soldierName,
            @Param("soldierWeapon") String soldierWeapon);

    /** update soldier info */
    void updateOneSoldier(
            @Param("soldierName") String soldierName,
            @Param("soldierWeapon") String soldierWeapon,
            @Param("soldierId") Integer soldierId);

    /** remove a soldier info */
    void removeOneSoldier(@Param("soldierId") Integer soldierId);

}

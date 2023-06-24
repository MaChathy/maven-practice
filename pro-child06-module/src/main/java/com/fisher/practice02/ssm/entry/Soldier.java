package com.fisher.practice02.ssm.entry;

import lombok.Data;

/**
 * Soldier实体类
 * @author fisher
 * @version 1.0.1 2023/6/24 - 18:57
 */
@Data
public class Soldier {

    private Integer soldierId;
    private String soldierName;
    private String soldierWeapon;

}

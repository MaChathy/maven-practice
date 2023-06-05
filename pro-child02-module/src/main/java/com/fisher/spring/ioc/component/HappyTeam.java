package com.fisher.spring.ioc.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IoC 构造器注入组件
 * @author fisher
 * @version 1.0.1 2023/6/5 - 15:29
 */
@Data
@NoArgsConstructor
public class HappyTeam {

    private String teamName;
    private Integer memberCount;
    private Double memberSalary;

    public HappyTeam(String teamName, Integer memberCount,Double memberSalary){
        this.teamName = teamName;
        this.memberCount = memberCount;
        this.memberSalary = memberSalary;
    }
}

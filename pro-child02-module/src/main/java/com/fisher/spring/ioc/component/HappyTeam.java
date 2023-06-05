package com.fisher.spring.ioc.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * IoC 构造器注入组件
 * 给组件添加集合属性
 * @author fisher
 * @version 1.1.1 2023-6-5 16:00:34
 */
@Data
@NoArgsConstructor
public class HappyTeam {

    private String teamName;
    private Integer memberCount;
    private Double memberSalary;
    private List<String> memberList;

    public HappyTeam(String teamName, Integer memberCount,Double memberSalary){
        this.teamName = teamName;
        this.memberCount = memberCount;
        this.memberSalary = memberSalary;
    }
}

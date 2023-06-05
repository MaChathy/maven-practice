package com.fisher.spring.ioc.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IoC 特殊值处理组件
 * @author fisher
 * @version 1.0.1 2023/6/5 - 15:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropValue {

    private String commonValue;
    private String expression;

}

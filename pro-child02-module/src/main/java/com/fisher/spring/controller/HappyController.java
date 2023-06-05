package com.fisher.spring.controller;

import com.fisher.spring.service.HappyService;
import lombok.Getter;
import lombok.Setter;

/**
 * controller 自动装配需要的service组件
 * @author fisher
 * @version 1.0.1 2023/6/5 - 16:07
 */
@Getter
@Setter
public class HappyController {

    private HappyService happyService;


}

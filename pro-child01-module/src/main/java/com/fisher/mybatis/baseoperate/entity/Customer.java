package com.fisher.mybatis.baseoperate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 客户实体类
 * @author fisher
 * @version 1.0.1 2023/6/2 - 16:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    //客户id
    private Integer customerId;
    //客户姓名
    private String customerName;

    //客户订单（一个客户对应多个订单）
    private List<Order> orderList;
}

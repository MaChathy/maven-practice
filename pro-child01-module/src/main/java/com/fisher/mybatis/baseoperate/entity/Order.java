package com.fisher.mybatis.baseoperate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单实体类
 * @author fisher
 * @version 1.0.1 2023/6/2 - 16:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    //订单id
    private Integer orderId;
    //订单名
    private String orderName;
    //客户id
    private Integer customerId;

    //订单客户（一个订单对应一个客户）
    private Customer customer;
}

package com.fisher.mybatis.mapper;

import com.fisher.mybatis.baseoperate.entity.Order;

/**
 * OrderMapper接口 与 OrderMapper.xml相对应
 * @author fisher
 * @version 1.0.1 2023/6/2 - 17:17
 */
public interface OrderMapper {

    //查询指定订单信息
    Order selectOrderWithCustomer(Integer orderId);
}
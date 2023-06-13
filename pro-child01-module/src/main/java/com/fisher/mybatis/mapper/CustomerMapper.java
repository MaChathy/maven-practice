package com.fisher.mybatis.mapper;

import com.fisher.mybatis.baseoperate.entity.Customer;

/**
 * CustomerMapper 对应 CustomersMapper.xml
 * @author fisher
 * @version 1.0.1 2023/6/2 - 17:56
 */
public interface CustomerMapper {

    //查询客户信息
    Customer selectCustomerWithOrderList(Integer customerId);

}

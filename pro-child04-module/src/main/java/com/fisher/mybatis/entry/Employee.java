package com.fisher.mybatis.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * the entry of the employee
 * @author fisher
 * @version 1.0.1 2023/6/11 - 19:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer empId;

    private String empName;

    private Double empSalary;

}

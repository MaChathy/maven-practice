package com.fisher.mybatis.dao;

import com.fisher.mybatis.baseoperate.entity.Employees;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 声明Mapper接口,与EmployeeMapper.xml文件相对应
 *
 * EmployeeMapper接口 -> EmployeeMapper.xml
 * 接口全类名          -> mapper.namespaces
 * 接口中方法名        -> select.id
 * 接口中方法返回值类型 -> select.resultType
 * 接口方法的参数      -> SQL语句中的参数("#{args}")
 *
 * @author fisher
 * @version 1.0.1 2023/6/2 - 12:42
 */
public interface EmployeeMapper {
    //查询单个员工
    Employees selectEmployee(Integer empId);

    //插入员工信息
    int insertEmployee(Employees employee);

    //修改员工信息
    int updateEmployee(Employees employee);

    //删除员工信
    int deleteEmployee(Employees employee);

    //根据员工id删除员工信息
    int deleteEmployeeById(Integer emoId);

    //修改指定的员工信息
    int updateEmployeeById(@Param("empId") Integer emoId,@Param("empSalary") Double empSalary);

    //修改指定的员工信息
    int updateEmployeeByMap(Map<String,Object> paramMap);

}

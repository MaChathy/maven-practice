package com.fisher.practice.dao;

/**
 * 数据访问对象
 * @author fisher
 * @version 1.0.1 2023/6/13 - 20:21
 */
public interface UserDao {
    /**
     * 添加用户方法
     * @param userName 用户名
     * @param email 用户邮箱
     * @param userPwd 用户密码
     * @return 1
     */
    int addUser(String userName,String email,String userPwd) ;

    /**
     * 查找单个用户记录
     * @param email 用户邮箱
     * @return 1
     */
    int selectOneUser(String email,String userPwd,String userName) ;

}



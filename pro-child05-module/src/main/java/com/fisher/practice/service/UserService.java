package com.fisher.practice.service;

import com.sun.deploy.security.BadCertificateDialog;

/**
 * Service层
 * @author fisher
 * @version 1.0.1 2023/6/13 - 20:15
 */
public interface UserService {
    /**
     * 添加用户方法
     * @param userName 用户名
     * @param email 用户邮箱
     * @param userPwd 用户密码
     * @return 1
     */
    int addUser(String userName,String email,String userPwd);

    /**
     * 查找单个用户
     * @param email 用戶名
     * @return 1
     */
    int selectOneUser(String email,String userPwd,String userName);
}

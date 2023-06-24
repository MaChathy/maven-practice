package com.fisher.practice.service.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.fisher.practice.dao.UserDao;
import com.fisher.practice.dao.impl.UserDaoImpl;
import com.fisher.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * UserService 实现类
 * @author fisher
 * @version 1.0.1 2023/6/13 - 20:18
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserDao userDaoImpl;

    public UserServiceImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public int addUser(String userName, String email, String userPwd) {

        return userDaoImpl.addUser(userName, email, userPwd);
    }

    @Override
    public int selectOneUser(String email,String userPwd,String userName) {
        return userDaoImpl.selectOneUser(email,userPwd,userName);
    }
}

package com.fisher.practice.dao.impl;

import com.fisher.practice.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * UserDao 接口 的纯净实现
 * @author fisher
 * @version 1.0.1 2023/6/13 - 20:23
 */
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(String userName, String email, String userPwd) {
        String sql = "INSERT INTO t_users (user_name, email, user_pwd) VALUES(?,?,?)";
        int result = jdbcTemplate.update(sql, userName, email, userPwd);
        if (result == 1) {
            return result;
        }
        return -1;
    }

    @Override
    public int selectOneUser(String email,String userPwd,String userName) {
        String sql = "SELECT user_id from t_users where email = ? and user_pwd = ? and user_name = ?";
        try {
            Integer userId = jdbcTemplate.queryForObject(sql, Integer.class, email,userPwd,userName);
            if (userId != null) {
                return userId;
            }

        } catch (Exception e) {
        }
        return -1;
    }
}

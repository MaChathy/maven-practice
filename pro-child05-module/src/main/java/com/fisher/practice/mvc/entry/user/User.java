package com.fisher.practice.mvc.entry.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 * @author fisher
 * @version 1.0.1 2023/6/13 - 20:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userName;
    private String email;
    private String userPwd;

}

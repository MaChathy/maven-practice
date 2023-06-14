package com.fisher.practice.mvc.handle;

import com.fisher.practice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Spring-mvc hello world
 * <br>把处理请求的类称为Handle类
 * <br>把处理请求的方法称为Handle方法
 * @author fisher
 * @version 1.0.1 2023/6/13 - 18:43
 */
@Slf4j
@Controller
@RequestMapping("/demo01")
public class Demo01HelloHandle {

    private final UserService userServiceImpl;

    public Demo01HelloHandle(@Qualifier("userService") UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }


    /**
     * <code>@RequestMapping</code>注解在请求地址和java方法之间建立映射关系
     * @return portal
     */
    @RequestMapping("/")
    public String showPortal(){
        return "portal";
    }

    @RequestMapping(
            value = {"/say/hello/to/spring/mvc"})
    public String sayHello(HttpServletRequest request){
        log.debug("hello world.");
        HttpSession session = request.getSession();
        session.setAttribute("testValue","hello");
        return "target";
    }

    @RequestMapping(value = "/user/login")
    public String login(){

        return "login";
    }

    @RequestMapping(value = "/user/sign")
    public String sign(){
        return "sign";
    }

    @RequestMapping(value = "/user/sign/success",method = RequestMethod.POST)
    public String signSuccess(
            @RequestParam("userName") String userName,
            @RequestParam("email") String email,
            @RequestParam("userPwd") String password){
        if ((userServiceImpl.selectOneUser(email,password,userName) == -1 )) {
            int addUser = userServiceImpl.addUser(userName, email, password);
            if (addUser == 1) {
                log.debug("注册成功");
            } else {
                log.debug("注册失败");
            }
            return "signSuccess";
        }

        return "userAlreadyExists";
    }

    @RequestMapping(value = "/user/home",method = RequestMethod.POST)
    public String home(
            @RequestParam("userName") String userName,
            @RequestParam("email") String email,
            @RequestParam("userPwd") String password){

        log.debug("【用户登陆信息】userName:"+userName+",email:"+email+",password:"+password);
        if ((userServiceImpl.selectOneUser(email,password,userName) != -1 )) {
            log.debug("登陆成功");
            return "userHome";
        }
        return "noSuchUser";
    }

}

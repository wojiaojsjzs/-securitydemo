package com.jzs.securitydemo.controller;

import org.apache.catalina.User;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
        @RequestMapping("/")
        public String home(){
            return "hello spring boot";

        }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";

    }

    //Role全锥admin
    //方法调用前检查权限
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    //方法调用后检查权限
    @PostAuthorize("hasRole('ROLE_ADMIN')")
    //集合类参数或返回值过滤
    @PreFilter("")
    @PostFilter("")
    @RequestMapping("/roleAuth")
    public String role(){
            return "roleAuth";
    }


    //参数小于10 传入的userName必须与当前登录的userName一致
    @PreAuthorize("#id<10 or principal.username.equals(#userName) and user.username.equals('abc')")
    //返回值需要是偶数
    @PostAuthorize("returnObject%2==0")
    //集合类参数或返回值过滤
    @PreFilter("")
    @PostFilter("")
    @RequestMapping("/roleAuth2")
    public Integer role2(Integer id, String userName, User user){
        return id;
    }



    //集合类参数或返回值过滤
    @PreFilter("filterObject%2==0")
    @PostFilter("filterObject%4==0")
    @RequestMapping("/roleAuth2")
    public List<Integer> role2(List<Integer> id){
        return id;
    }

}

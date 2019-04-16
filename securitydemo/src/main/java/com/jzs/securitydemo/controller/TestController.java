package com.jzs.securitydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/roleAuth")
    public String role(){
            return "roleAuth";
    }

}

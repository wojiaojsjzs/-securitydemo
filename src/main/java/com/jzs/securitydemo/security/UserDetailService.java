package com.jzs.securitydemo.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 自定义用户的接口
 */
@Component
public class UserDetailService implements UserDetailsService {


    /**
     * 根据用户名查找用户信息
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //注入mapper查询数据库
        //authorities 权限
        //
        System.out.println(userName);
        return new User(userName,"password", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
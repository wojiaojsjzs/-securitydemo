package com.jzs.securitydemo.security;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import sun.security.rsa.RSASignature;
import sun.security.util.Password;


public class PasswordEncodeUtil implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        /**
         * 如果密码有加密的话放开下面的代码
         */
        //PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //return passwordEncoder.encode(charSequence);
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        /**
         * 如果密码有加密的话放开下面的代码
         */
       // PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //return passwordEncoder.matches(charSequence,s);
        return s.equals(charSequence.toString());
    }

    public static void main(String[] args) {
       /* PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encode = passwordEncoder.encode("123");

        System.out.println(passwordEncoder.matches("122",encode));*/

    }
}
package com.jzs.securitydemo.Util;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.rsa.RSASignature;
import sun.security.util.Password;


public class PasswordEncodeUtil implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder.matches(charSequence,s);
    }

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encode = passwordEncoder.encode("123");

        System.out.println(passwordEncoder.matches("122",encode));

    }
}
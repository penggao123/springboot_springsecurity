package com.mukewang.spring_security_test;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName MyPasswordEncoder
 * @Description TODO
 * @Author gaopeng
 * @Date 2020/11/9 20:58
 * @Version 1.0
 **/

//@Bean
public class MyPasswordEncoder implements PasswordEncoder{


    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}

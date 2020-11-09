package com.mukewang.spring_security_test;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName SpringSecurityConfig
 * @Description TODO
 * @Author gaopeng
 * @Date 2020/11/9 20:18
 * @Version 1.0
 **/

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    //在内存中注册用户及用户对应的密码
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("123456").roles("ADMIN");
        //可以在内存中加入多个用户
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("user").password("123456").roles("ADMIN");

        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("gaopeng").password("123456").roles("USER");
    }

    //http请求的拦截
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()//不经过验证
                .anyRequest().authenticated()//其他请求需要经过验证
                .and()
                .logout().permitAll()
                .and()
                .formLogin();
        http.csrf().disable();//关闭csrf认证
    }

    //要忽略的文件
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/js/**", "/css/**", "/image/**");
    }
}

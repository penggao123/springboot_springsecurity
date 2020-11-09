package com.mukewang.spring_security_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityTestApplication.class, args);
	}


	@GetMapping("/")
	public String hello(){

		return "helle";

	}


	@GetMapping("/login")
	public String home(){

		return "success  login";

	}




	/**
	  * @Author gaopeng
	  * @Description //TODO 使用角色认证登录
	  * @Date 20:49 2020/11/9
	  * @param
	  * @return java.lang.String
	  **/

	@PreAuthorize("hasRole('ROLE_ADMIN')")//配置（ADMIN角色）哪个角色的用户访问(@EnableGlobalMethodSecurity(prePostEnabled = true) 才能生效)
	@GetMapping("/loginAuth")
	public String loginAuth(){
        return "loginAuth成功";
    }



}

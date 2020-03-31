//package com.lhj.web.secure;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.stereotype.Component;
//
///**
// * @Author lhj
// * @Date 2020/3/11 15:58
// * @Description
// */
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .mvcMatchers("/","/login")
//                .permitAll().anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/login").permitAll()
//                .and()
//                .logout().permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
//        builder.inMemoryAuthentication().withUser("user").password("123456").roles("USER");
//    }
//}

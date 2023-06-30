package com.management.studentDemo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/classInfo", "/classInfo/addClassInfo", "/updateClassInfo/{className}", "/deleteClassInfo/{className}").hasRole("ADMIN")
                .antMatchers("/student/addNewStudent", "/student", "/deleteStudent/{studentId}").hasRole("ADMIN")
                .antMatchers("/teacher/addNewTeacher", "/teacher", "/deleteTeacher/{teacherId}", "updateTeacher/{teacherId}").hasRole("ADMIN")
                .antMatchers("/teacher/{teacherId}").hasAnyRole("ADMIN", "TEACHER")
                .antMatchers("/student/{studentId}",  "/updateStudent/{studentId}").hasAnyRole("STUDENT", "ADMIN")

//                .antMatchers("/student/**").access("hasRole('STUDENT') and @securityService.isAccountOwner(authentication, #studentId)")
//                .antMatchers("/teacher/**").access("hasRole('TEACHER') and @securityService.isAccountOwner(authentication, #teacherId)")

                .anyRequest().authenticated()
                .and().httpBasic()
                .and()
                .logout().permitAll();
    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}admin123").roles("ADMIN")
                .and()
                .withUser("teacher").password("{noop}teacher123").roles("TEACHER")
                .and()
                .withUser("student").password("{noop}student123").roles("STUDENT");

    }

}

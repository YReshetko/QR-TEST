package com.my.example.security

import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.*
import org.springframework.format.FormatterRegistry
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.*
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager

import org.springframework.security.core.userdetails.User
import org.springframework.validation.MessageCodesResolver
import org.springframework.validation.Validator
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.HandlerMethodReturnValueHandler
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.config.annotation.*

@EnableWebSecurity
class WebSecurityConfig : WebMvcConfigurerAdapter() {

    @Bean
    @Throws(Exception::class)
    fun userDetailsService(): UserDetailsService {
        val manager = InMemoryUserDetailsManager()
        manager.createUser(User.withUsername("user").password("password").roles("USER").build())
        return manager
    }

    @Throws(Exception::class)
    fun configure(http: HttpSecurity){
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
        .permitAll();
    }
}
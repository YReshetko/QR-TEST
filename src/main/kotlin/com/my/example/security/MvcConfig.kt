package com.my.example.security

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class MvcConfig: WebMvcConfigurerAdapter() {
    override fun addViewControllers(registry: ViewControllerRegistry?) {
        super.addViewControllers(registry)
        registry?.addViewController("/")?.setViewName("home");
        registry?.addViewController("/home")?.setViewName("home");
        registry?.addViewController("/hello")?.setViewName("hello");
        registry?.addViewController("/login")?.setViewName("login");
    }
}
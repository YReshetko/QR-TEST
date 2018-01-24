package com.my.example.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.*
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.*
import org.springframework.web.accept.ContentNegotiationStrategy

@Configuration
@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    protected override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .antMatchers(",", "/home").permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().permitAll()
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder)
    {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
    }

    override fun setContentNegotationStrategy(contentNegotiationStrategy: ContentNegotiationStrategy?) {
        super.setContentNegotationStrategy(contentNegotiationStrategy)
    }
    /*@Bean
    @Throws(Exception::class)
    fun userDetailsService(): UserDetailsService {
        val manager = InMemoryUserDetailsManager()
        manager.createUser(User.withUsername("user").password("password").roles("USER").build())
        return manager
    }*/

    /*@Throws(Exception::class)
    fun configure(http: HttpSecurity){
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
        .permitAll();
    }*/

  /*  @Configuration
    @Order(1)
    inner class ApiWebSecurityConfigurationAdapter: WebSecurityConfigurerAdapter() {
        @Throws(Exception::class)
        protected override fun configure(http:HttpSecurity){
            http*/
                   // .antMatcher("/api/**")
                    /*.authorizeRequests()
                    .anyRequest().hasRole("ADMIN")
                    .and()
                    .httpBasic()
        }
    }

    @Configuration
    inner class FormLoginWebSecurityConfigurationAdapter: WebSecurityConfigurerAdapter() {
        @Throws(Exception::class)
        protected override fun configure(http:HttpSecurity){
            http
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage("/login.html")
        }
    }*/
}
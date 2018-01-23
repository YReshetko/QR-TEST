package com.my.example.security

import org.springframework.security.web.context.*
class SecurityWebApplicationInitializer : AbstractSecurityWebApplicationInitializer(WebSecurityConfig::class.java)
package com.my.example.staticcontent

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class StaticController {
    @RequestMapping(value = "/hi", method = arrayOf(RequestMethod.GET))
    fun index() = "startPage.html"
    @RequestMapping(value = "/error", method = arrayOf(RequestMethod.GET, RequestMethod.POST))
    fun error() = "errorPage.html"
}
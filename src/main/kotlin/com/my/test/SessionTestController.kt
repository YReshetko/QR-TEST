package com.my.test

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView
import javax.servlet.http.HttpSession


@RestController
@RequestMapping("/session")
class SessionTestController {

    // Redirect example
    @GetMapping("/rdt")
    fun getForm1(redirectAttributes: RedirectAttributes):ModelAndView
    {
        return ModelAndView("redirect:/inputUser.html")
    }
    //Forward example
    @GetMapping("/fwd")
    fun getForm2(redirectAttributes: RedirectAttributes):ModelAndView
    {
        return ModelAndView("forward:/inputUser.html")
    }

    //Forward example
    @GetMapping("/priv")
    fun getPrivate(redirectAttributes: RedirectAttributes):ModelAndView
    {
        return ModelAndView("forward:/PrivatePage.html")
    }

    // Set into session
    @PostMapping(value = "/setuser", params = arrayOf("name"))
    fun setUser(@RequestParam(value = "name") name: String, sess:HttpSession):String
    {
        sess.setAttribute("name", name)
        return "OK"
    }

    // Get from session
    @GetMapping("/getuser")
    fun getUser(@SessionAttribute(name = "name") name:String):String
    {
        return name
    }
}



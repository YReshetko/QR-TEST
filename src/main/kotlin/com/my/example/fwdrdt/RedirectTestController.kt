package com.my.example.fwdrdt

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView
import java.io.File
import javax.servlet.http.HttpSession


@RestController
@RequestMapping("/redirect")
class RedirectTestController {

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
    fun getPrivate(redirectAttributes: RedirectAttributes):String
    {
        val f:File = File("web/html/PrivatePage.html")
        return f.absolutePath + "; exists: " + f.exists()
    }

    //@GetMapping("**")
    /*fun commonRedirect(redirectAttributes: RedirectAttributes):RedirectView
    {
        redirectAttributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        redirectAttributes.addAttribute("attribute", "redirectWithRedirectView");
        return RedirectView("/ru/greeting")
    }*/
}



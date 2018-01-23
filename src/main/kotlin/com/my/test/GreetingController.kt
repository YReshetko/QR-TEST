package com.my.test

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/{leng}")
class GreetingController {
   val counter = AtomicLong();


    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String, @PathVariable("leng") leng:String):Greeting
    {
        return Greeting(counter.incrementAndGet(), leng(leng) + ", $name")
    }
    //@GetMapping("**")
    fun commonRedirect(redirectAttributes: RedirectAttributes):RedirectView
    {
        redirectAttributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        redirectAttributes.addAttribute("attribute", "redirectWithRedirectView");
        return RedirectView("/ru/greeting")
    }

    fun leng(leng:String):String {
        var out:String = "";
        when(leng){
            "ru" -> out = "Privet"
            "en" -> out = "Hello"
            else -> out = "Hello"
        }
        return out;
    }

}
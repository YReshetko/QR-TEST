package com.my.example.localization

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/{lang}")
class LocalizationController
{

    @GetMapping("/hello")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String, @PathVariable("lang") lang:String):String
    {
        return lang(lang) + ", $name"
    }


    fun lang(lang:String):String {
        var out:String = "";
        when(lang){
            "ru" -> out = "Privet"
            "en" -> out = "Hello"
            else -> out = "Hello"
        }
        return out;
    }

}
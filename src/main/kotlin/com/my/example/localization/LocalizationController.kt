package com.my.example.localization

import org.springframework.cglib.core.Local
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView
import java.util.*
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/{lang}")
class LocalizationController
{
    val localeFactory:LocaleFactory = LocaleFactory.instance
    @GetMapping("/hello")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String, @PathVariable("lang") lang:String):ModelAndView
    {
        val mod:ModelAndView = ModelAndView("forward:/internLogForm.html")
        val locale:Locale = lang(lang)

        mod.addObject("ui.button.login", localeFactory.getMessage("ui.button.login", locale, emptyArray()))
        mod.addObject("ui.button.logout", localeFactory.getMessage("ui.button.logout", locale, emptyArray()))
        mod.addObject("ui.button.registration", localeFactory.getMessage("ui.button.registration", locale, emptyArray()))
        return mod
    }


    fun lang(lang:String):Locale {
        val out:Locale
        when(lang){
            "ru" -> out = Locale("RU", "ru")
            "en" -> out = Locale.ENGLISH
            else -> out = Locale("RU", "ru")
        }
        return out;
    }

}
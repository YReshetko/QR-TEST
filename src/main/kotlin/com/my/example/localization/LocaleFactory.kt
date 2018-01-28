package com.my.example.localization

import org.springframework.context.support.ClassPathXmlApplicationContext
import java.util.*

class LocaleFactory private constructor()
{
    val context = ClassPathXmlApplicationContext("locale.xml")
    private object Holder {val INSTANCE = LocaleFactory()}
    companion object {
        val instance: LocaleFactory by lazy { Holder.INSTANCE }
    }
    public fun getMessage(messageName:String, locale:Locale, value: Array<Any>) = context.getMessage(messageName, value, locale)
}
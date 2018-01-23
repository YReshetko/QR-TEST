package com.my.example.model

import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/model")
class GreetingController {
   val counter = AtomicLong();


    @GetMapping("/hi")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting
    {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }

}
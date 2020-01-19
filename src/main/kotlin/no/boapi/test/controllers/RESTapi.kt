package no.boapi.test.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class RestAPIsController {
    @RequestMapping("/home")
    fun findAll(): String {
        return "Hello World!"
    }
}
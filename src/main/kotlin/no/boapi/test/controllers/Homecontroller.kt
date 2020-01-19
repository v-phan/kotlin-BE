package no.boapi.test.controllers

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class Homecontroller {
    @RequestMapping("/")
    fun findAll(): String {
        return "Welcome to the page!"
    }
}
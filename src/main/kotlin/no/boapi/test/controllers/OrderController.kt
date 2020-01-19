package no.boapi.test.controllers

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

    @PostMapping
    fun purchase(): String{

        return "Ok"
    }
}
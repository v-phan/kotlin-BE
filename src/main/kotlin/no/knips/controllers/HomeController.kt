package no.knips.controllers

import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@Component
class HomeController {

    @RequestMapping("/")
    fun hello() : String {
        return "Velkommen til Admin APIet"
    }

}
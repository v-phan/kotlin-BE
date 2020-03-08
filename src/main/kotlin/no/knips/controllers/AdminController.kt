package no.knips.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AdminController{

    @GetMapping("/orders")
    fun allOrders(): String = "Hei"

    @PostMapping("/orders/{orderID}/finished")
    fun finishOrder(){}

    @GetMapping("/orders/live")
    fun liveOrders(){}

}
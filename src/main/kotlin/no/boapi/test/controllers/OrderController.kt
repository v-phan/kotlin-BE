package no.boapi.test.controllers

import org.apache.http.HttpHeaders
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.impl.client.HttpClients
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderController {

    @PostMapping
    fun purchase(): String{
        val client: HttpClient = HttpClients.custom().build()
        val request: HttpUriRequest = RequestBuilder.get()
                .setUri("https://apitest.vipps.no/accesstoken/get")
                .setHeader("client_id", "c0lLeUtJUTI4b01kRnptYWhOQXE=")
                .setHeader("client_secret", "4fe4cd4f-7998-498c-be17-056a8d9efd58")
                .setHeader("Ocp-Apim-Subscription-Key", "982b85d191fb48ff9c655cfbc4e162c4")
                .build()
        client.execute(request)
        return "Ok"
    }
}
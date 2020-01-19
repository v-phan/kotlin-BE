package no.boapi.test.controllers

import org.apache.http.HttpHeaders
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpUriRequest
import org.apache.http.client.methods.RequestBuilder
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderController {

    @PostMapping
    fun purchase(): String{
        var client: CloseableHttpClient  = HttpClients.createDefault();
        var httpPost: HttpPost = HttpPost("http://www.example.com");

        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        var response: CloseableHttpResponse = client.execute(httpPost);
        client.close();
        println(response)
        return "Ok"
    }
}
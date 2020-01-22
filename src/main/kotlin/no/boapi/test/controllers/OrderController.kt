package no.boapi.test.controllers

import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.apache.http.util.EntityUtils;


@RestController
class OrderController {

    @GetMapping("/token")
    fun purchase(): String{
        var client = HttpClients.createDefault();
        var postrequest = HttpPost("https://apitest.vipps.no");

        postrequest.setHeader("Content-type", "application/json");
        postrequest.addHeader("client_id", "4fe4cd4f-7998-498c-be17-056a8d9efd58");
        postrequest.addHeader("client_secret", "c0lLeUtJUTI4b01kRnptYWhOQXE=");
        postrequest.addHeader("Ocp-Apim-Subscription-Key", "982b85d191fb48ff9c655cfbc4e162c4");

        var response = client.execute(postrequest).statusLine.toString();

        client.close();
        return response
    }
}
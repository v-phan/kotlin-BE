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
        var client: CloseableHttpClient  = HttpClients.createDefault();
        var httpPost: HttpPost = HttpPost("https://apitest.vipps.no");

        httpPost.setHeader("client_id", "c0lLeUtJUTI4b01kRnptYWhOQXE=");
        httpPost.setHeader("client_secret", "4fe4cd4f-7998-498c-be17-056a8d9efd58");
        httpPost.setHeader("Ocp-Apim-Subscription-Key", "982b85d191fb48ff9c655cfbc4e162c4");

        var response: CloseableHttpResponse = client.execute(httpPost);


        client.close();
        return response.getStatusLine().toString();
    }
}
package no.boapi.core.controllers

import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.BasicResponseHandler
import org.apache.http.impl.client.HttpClients
import org.json.JSONException
import org.json.JSONObject
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.IOException


@RestController
class OrderController {

    @RequestMapping("/token")
        fun purchase(): String{
        var client = HttpClients.createDefault();
        var postrequest = HttpPost("https://apitest.vipps.no/accesstoken/get");
        var token = "noe gikk galt";

        postrequest.addHeader("client_id", "4fe4cd4f-7998-498c-be17-056a8d9efd58");
        postrequest.addHeader("client_secret", "c0lLeUtJUTI4b01kRnptYWhOQXE=");
        postrequest.addHeader("Ocp-Apim-Subscription-Key", "982b85d191fb48ff9c655cfbc4e162c4");

        try{
            var response: HttpResponse = client.execute(postrequest);

            var handler = BasicResponseHandler();
            var responseString: String = handler.handleResponse(response);
            var jsonobject = JSONObject(responseString)
            token = jsonobject.getString("access_token");
            client.close();


            return token
        }catch(j: JSONException){
            j.printStackTrace()
        }catch(i: IOException){
            i.printStackTrace()
        }
        return token

    }
}
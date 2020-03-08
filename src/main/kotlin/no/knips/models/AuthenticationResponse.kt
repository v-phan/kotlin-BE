package no.knips.models

class AuthenticationResponse (jwt: String ){

    private val jwt = jwt
    fun getJwt(): String = jwt

}
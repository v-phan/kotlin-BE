package no.knips.controllers

import com.google.gson.Gson
import no.knips.models.AuthenticationRequest
import no.knips.models.AuthenticationResponse
import no.knips.repositories.AccountRepository
import no.knips.services.MyUserDetailsService
import no.knips.util.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*
import java.lang.reflect.Method

@Component
@RestController
class AuthenticationController(private val authenticationManager: AuthenticationManager, private val userDetailsService: MyUserDetailsService, private val jwtTokenUtil: JWTUtil){

    @PostMapping("/authenticate")
//    fun ash(): String = "hei"
    fun createAuthenticationToken(@RequestBody authenticationReq : AuthenticationRequest): ResponseEntity<Any> {
        try{
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(authenticationReq.username, authenticationReq.password))
        }catch (e: BadCredentialsException){
            throw Exception("Incorrect username or password", e)
        }catch (e: Exception){
            throw Exception("Something else is wrong", e)
        }
        val userDetails: UserDetails = userDetailsService.loadUserByUsername(authenticationReq.username)

        val jwt: String = jwtTokenUtil.generateToken(userDetails)

        return ResponseEntity.ok(AuthenticationResponse(jwt))
    }
}
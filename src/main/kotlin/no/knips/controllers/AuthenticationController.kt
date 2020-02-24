package no.knips.controllers

import no.knips.models.AuthenticationRequest
import no.knips.models.AuthenticationResponse
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

    @RequestMapping("/test")
    fun hello() : String = "Hei verden"

    @RequestMapping("/authenticate", method = [RequestMethod.POST])
    @Throws(Exception::class)
    fun createAuthenticationToken(@RequestBody authenticationReq : AuthenticationRequest): ResponseEntity<Any> {
        try{
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(authenticationReq.getUsername(), authenticationReq.getPassword()))
        }catch (e: BadCredentialsException){
            throw Exception("Incorrect username or password", e)
        }catch (e: Exception){
            throw Exception("Something else is wrong", e)
        }
        val userDetails: UserDetails = userDetailsService.loadUserByUsername(authenticationReq.getUsername())

        val jwt: String = jwtTokenUtil.generateToken(userDetails)

        return ResponseEntity.ok(AuthenticationResponse(jwt))
    }
}
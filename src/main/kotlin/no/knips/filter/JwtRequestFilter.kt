package no.knips.filter

import no.knips.services.MyUserDetailsService
import no.knips.util.JWTUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.BeanIds
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class JwtRequestFilter(private val jwtUtil: JWTUtil, private val myUserDetailsService: MyUserDetailsService) : OncePerRequestFilter() {

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(httpServletRequest: HttpServletRequest, httpServletResponse: HttpServletResponse, filterChain: FilterChain) {
        val authorizationHeader:String? = httpServletRequest.getHeader("Authorization")
        if(authorizationHeader != null){
            if (authorizationHeader.startsWith("JWT ")) {
                var jwt = authorizationHeader.substring(4)
                var username = jwtUtil.extractUsername(jwt)
                if (SecurityContextHolder.getContext().authentication == null) {
                    val userDetails: UserDetails = myUserDetailsService.loadUserByUsername(username)
                    if (jwtUtil.validateToken(jwt, userDetails)) {
                        val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                        usernamePasswordAuthenticationToken.details = WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
                        SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
                    }
                }
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse)
    }
}
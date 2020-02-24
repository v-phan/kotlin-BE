package no.knips.config

import no.knips.filter.JwtRequestFilter
import no.knips.services.MyUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.BeanIds
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component

@Component
@EnableWebSecurity
class SecurityConfigurer(private val myUserDetailsService: MyUserDetailsService, private val jwtRequestFilter: JwtRequestFilter) : WebSecurityConfigurerAdapter() {

    @Bean
    override fun authenticationManagerBean(): AuthenticationManager = super.authenticationManagerBean()

    @Bean
    fun passwordEncoder(): PasswordEncoder = NoOpPasswordEncoder.getInstance()

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder){
        auth.userDetailsService(myUserDetailsService)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/authenticate")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) { // configure AuthenticationManager so that it knows from where to load
    // user for matching credentials
    // Use BCryptPasswordEncoder
        auth.userDetailsService<UserDetailsService>(myUserDetailsService).passwordEncoder(passwordEncoder())
    }
}
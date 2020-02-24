package no.knips.services

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class MyUserDetailsService: UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        if(username.equals("name")){
            return User("name","pass", mutableListOf())
        }
        else if(username.equals("foo")){
            return User("foo","foo", mutableListOf())
        }
        else{
            throw UsernameNotFoundException("Fant ikke bruker")
        }
    }


}

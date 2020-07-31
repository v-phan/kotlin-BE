package no.knips.services

import no.knips.repositories.AccountRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
open class MyUserDetailsService (private val accountRepository: AccountRepository) : UserDetailsService {

//    override fun loadUserByUsername(username: String): UserDetails {
//        return AccountUserDetails(accountRepository.findByAccountname(username)!!)
//    }

        @Throws(UsernameNotFoundException::class)
        override fun loadUserByUsername(username: String): UserDetails {
//            return User("Bo","040715", mutableListOf())
            var account = accountRepository.findByUsername(username)
            if(account == null){
                throw UsernameNotFoundException("not found")
            }
            return User(account.getUsername(),account.getPassword(), mutableListOf() )
    }

}

//import no.knips.entities.Account
//import no.knips.repositories.AccountRepository
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.core.userdetails.UsernameNotFoundException
//import org.springframework.stereotype.Component
//import org.springframework.stereotype.Service
//import java.util.*
//
//
//@Component
//@Service
//class MyUserDetailsService(private val accountRepository: AccountRepository): UserDetailsService {
//
//    @Throws(UsernameNotFoundException::class)
//    override fun loadUserByUsername(username: String): UserDetails {
//        var account = accountRepository.findByAccountname(username)
//        if(account == null){
//            throw UsernameNotFoundException("not found")
//
//        }
//        return account
//    }

//    @Throws(UsernameNotFoundException::class)
//    override fun loadUserByUsername(s: String): UserDetails {
//        return Account("Bo", "Bo","admin")
//    }




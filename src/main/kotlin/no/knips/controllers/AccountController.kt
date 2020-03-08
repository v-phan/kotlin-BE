package no.knips.controllers

import no.knips.repositories.AccountRepository
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.google.gson.Gson
import no.knips.entities.Account
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.RequestBody

@Component
@RestController
class AccountController(private val accountRepository: AccountRepository, private val passwordEncoder: BCryptPasswordEncoder){

    var gson = Gson()
    @RequestMapping("/test")
    fun hello() : String {
        return gson.toJson(accountRepository.findAll())
    }


    @RequestMapping("/signup")
    fun createAccount(@RequestBody account : Account) : String{
        if(accountRepository.findByUsername(account.getUsername()) == null){
            account.setPassword(passwordEncoder.encode(account.getPassword()))
            accountRepository.save(account)
            return "Done"
        }
        return "Brukernavnet eksisterer, lag ny bruker med unikt brukernavn"
    }

    @RequestMapping("/reset")
    fun resetPassword(@RequestBody account: Account): String{
        var oldAccount = accountRepository.findByUsername(account.getUsername())
        oldAccount!!.setPassword(passwordEncoder.encode(account.getPassword()))
        accountRepository.save(oldAccount)
        return "done"
    }
}
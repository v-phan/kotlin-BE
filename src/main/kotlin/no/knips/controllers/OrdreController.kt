package no.knips.controllers

import no.knips.entities.Account
import no.knips.entities.Ordre
import no.knips.repositories.AccountRepository
import no.knips.repositories.OrdreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@Component
@RestController
class OrdreController(private val ordreRepository: OrdreRepository, private val accountRepository: AccountRepository) {

    @PostMapping("/ordre")
    fun importOrder(restaurantId: Int, order: String) {

    }

    @GetMapping("/tester")
    fun getmappingtest(){
        var ordre1 = Ordre(1,"Ram","ld");
        var ordre2 = Ordre(2,"Ram","lokd");
        var ordre3 = Ordre(2,"Ram","lokd");

        ordreRepository.save(ordre1);
        ordreRepository.save(ordre2);
        ordreRepository.save(ordre3);
    }
}
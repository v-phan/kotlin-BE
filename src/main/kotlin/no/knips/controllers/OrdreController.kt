package no.knips.controllers

import no.knips.entities.Account
import no.knips.entities.Ordre
import no.knips.repositories.AccountRepository
import no.knips.repositories.OrdreRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrdreController {

    @Autowired
    lateinit var accountRepository: AccountRepository

    @Autowired
    lateinit var ordreRepository: OrdreRepository

    @PostMapping
    fun importOrder(restaurantId: Int, order: String) {

    }
    @GetMapping("/tester")
    fun getmappingtest(){
        var user = Account ("niraj.sonawane@gmail.com", "$2a$10yRxRYK/s8vZCp.bgmZsD/uXmHjekuPU/duM0iPZw04ddt1ID9H7kK", "User");
        var test = Account	("test@gmail.com", "$2a$10YWDqYU0XJwwBogVycbfPFOnzU7vsG/XvAyQlrN34G/oA1SbhRW.W.", "User");
        accountRepository.save(user);
        accountRepository.save(test);


        var ordre1 = Ordre(1,"Ram","ld");
        var ordre2 = Ordre(2,"Ram","lokd");
        var ordre3 = Ordre(2,"Ram","lokd");

        ordreRepository.save(ordre1);
        ordreRepository.save(ordre2);
        ordreRepository.save(ordre3);
    }
}
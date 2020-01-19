package no.boapi.test.controllers

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
//import khttp.delete as httpDelete
import no.boapi.test.repositories.UserRepository
import no.boapi.test.models.PersonUser

@RestController
class UserController {

    @Autowired
    lateinit var repository: UserRepository

    @RequestMapping("/savepersons")
    fun save(): String {
        repository.save(PersonUser("Jack", arrayListOf()))
        repository.save(PersonUser("Adam",arrayListOf()))
        repository.save(PersonUser("Kim",arrayListOf()))
        repository.save(PersonUser("David",arrayListOf()))
        repository.save(PersonUser("Peter",arrayListOf()))
        repository.save(PersonUser("Martin",arrayListOf()))

//        repository.save(PersonUser("Jack"))
//        repository.save(PersonUser("Martin"))
//        repository.save(PersonUser("Stian"))
//        repository.save(PersonUser("GEre"))
//        repository.save(PersonUser("Julis"))
//        repository.save(PersonUser("aksdokao"))


        return "Done"
    }

    @RequestMapping("/persons")
    fun findAll() = repository.findAll()

}
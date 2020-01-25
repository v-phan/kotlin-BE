package no.boapi.core.controllers

import no.boapi.core.entities.Person
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
//import khttp.delete as httpDelete
import no.boapi.core.repositories.UserRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@RestController
class PersonController {

    @Autowired
    lateinit var users: UserRepository

    @PostMapping("/persons/add")
    fun save(@RequestBody user: Person): String {
        users.save(user)
        return "Done"
    }

    @RequestMapping("/persons")
    fun findAll() = users.findAll()
}
package no.boapi.test.controllers

import no.boapi.test.models.Person
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
//import khttp.delete as httpDelete
import no.boapi.test.repositories.UserRepository
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
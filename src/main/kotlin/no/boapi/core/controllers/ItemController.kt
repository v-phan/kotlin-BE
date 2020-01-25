package no.boapi.core.controllers

import org.springframework.beans.factory.annotation.Autowired

import no.boapi.core.entities.Item
import no.boapi.core.repositories.ItemRepository
import no.boapi.core.repositories.UserRepository
import org.springframework.web.bind.annotation.*


@RestController
class ItemController {

    @Autowired
    lateinit var repository: ItemRepository
    @Autowired
    lateinit var users: UserRepository

    @GetMapping("/items")
    fun findAll() :Iterable<Item> = repository.findAll()

    @PostMapping("/items/add")
    fun add(@RequestBody item: Item) : String {
        var person = users.findByUserId(item.userID)
        if(person != null){
            repository.save(item)
            person.additemID(item.itemId)
            users.save(person)
            return "Done"
        }
        return "Person does not exist"
    }

    @GetMapping("/items/{userId}")
    fun findById(@PathVariable userId: Int) : MutableList<Item> {
        var person = users.findByUserId(userId)
        var liste = person?.items
        var returnliste = mutableListOf<Item>()
        if (liste != null) {
            for(item in liste){
                if(repository.findById(item).isPresent){
                    returnliste.add(repository.findById(item).get())
                }
            }
        }
        return returnliste
    }
}


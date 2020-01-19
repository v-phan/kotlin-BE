package no.boapi.test.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
class PersonUser (
        val userName: String,
        var items: ArrayList<Int>,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val userId: Int = 0
        ){
        private constructor(): this("", arrayListOf<Int>())

        fun additemID(itemID: Int){
                items.add(itemID)
        }
}
package no.knips.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
class Ordre (
        val restaurantID: Int,
        val tRegistered: String,
        var tFinished: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val ordreId: Int = 0
){


}
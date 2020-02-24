package no.knips.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
class Account (
        val userName: String,
        var password: String,
        var role: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val accountID: Int = 0
        ){


}
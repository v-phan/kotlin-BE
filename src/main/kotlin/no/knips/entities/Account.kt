package no.knips.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Account(private var username: String,
              private var password: String,
              private var role: String,
              @Id @GeneratedValue(strategy = GenerationType.AUTO) val accountID: Int = 0){

        private constructor() : this("","","")


        fun getPassword(): String = password

        fun getUsername(): String = username

        fun setPassword(password: String){this.password = password}

        fun getRole(): String = role
}
package no.knips.entities


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Role(var rolename: String = "") {
    @Id
    @GeneratedValue
    val id: Int? = null
}
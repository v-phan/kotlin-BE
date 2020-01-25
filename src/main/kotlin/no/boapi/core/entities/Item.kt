package no.boapi.core.entities

import no.boapi.core.enums.ItemCategory
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import kotlin.collections.ArrayList

@Entity
class Item(
        var itemName: String,
        var currency: String,
        var category: Int,
        var images: ArrayList<String>,
        var latitude: Int,
        var longitude: Int,
        var userID: Int,
        var price: Int,
        var description: String,
        var itemTitle: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val itemId: Int = 0) {
    private constructor(): this("","",0, arrayListOf(""),0,0,0,0,
            "","")

}
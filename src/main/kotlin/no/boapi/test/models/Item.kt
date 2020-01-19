package no.boapi.test.models

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import kotlin.collections.ArrayList

@Entity
class Item(
        var itemName: String,
        var currency: String,
        var category: String,
        var images: ArrayList<String>,
        var latitude: Int,
        var longitude: Int,
        var userID: Int,
        var price: Int,
        var description: String,
        var itemTitle: String,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val itemId: Int = 0) {
    private constructor(): this("","","", arrayListOf(""),0,0,0,0,
            "","")

}
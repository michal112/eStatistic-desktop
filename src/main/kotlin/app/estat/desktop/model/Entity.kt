package app.estat.desktop.model

import java.util.*

abstract class Entity(val publicId: String)

class Cow(publicId: String, val name: String, val number: String, val book: Book, val birthday: Date, val father: Bull) : Entity(publicId) {
    val lactations: MutableList<Lactation> = mutableListOf();
    val mates: MutableList<Mate> = mutableListOf()

    enum class Book {
        MAIN,
        INTRODUCTORY,
        UNKNOWN
    }
}

class Bull(val name: String, val number: String) {
    val cows: MutableList<Cow> = mutableListOf()
    val mates: MutableList<Mate> = mutableListOf()
}

class Mate(publicId: String, val date: Date, val cow: Cow, val bull: Bull) : Entity(publicId)

class Lactation(publicId: String, val number: String, val date: Date, val cow: Cow) : Entity(publicId)
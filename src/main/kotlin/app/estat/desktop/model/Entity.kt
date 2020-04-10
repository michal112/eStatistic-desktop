package app.estat.desktop.model

import app.estat.desktop.util.localDate
import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.sql.Column

object Cows : IdTable<Int>("COW") {
    override val id: Column<EntityID<Int>> = integer("ID").autoIncrement().primaryKey().entityId()
    val publicId = varchar("PUBLIC_ID", 36)
    val name = varchar("NAME", 255)
    val number = varchar("NUMBER", 255)
    val book = enumeration("BOOK", Cow.Book::class.java)
    val birthday = date("DATE")
    //todo val bull = reference("BULL_ID", Bulls)
    //todo val lactations: MutableList<Lactation> = mutableListOf();
    //todo val mates: MutableList<Mate> = mutableListOf()
}

class Cow(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Cow>(Cows)

    var publicId by Cows.publicId
    var name by Cows.name
    var number by Cows.number
    var book by Cows.book
    var birthday by Cows.birthday
    //todo var bull by Bull referencedOn Cows.bull

    enum class Book {
        MAIN,
        INTRODUCTORY,
        UNKNOWN
    }

    fun data(): CowData {
        return CowData(publicId, name, number, birthday.localDate(), book)
    }
}

object Bulls : IdTable<Int>("BULL") {
    override val id: Column<EntityID<Int>> = integer("ID").autoIncrement().primaryKey().entityId()
    val publicId = varchar("PUBLIC_ID", 36)
    val name = varchar("NAME", 255)
    val number = varchar("NUMBER", 255)
    //todo val cows: MutableList<Cow> = mutableListOf()
    //todo val mates: MutableList<Mate> = mutableListOf()
}

class Bull(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Bull>(Bulls)

    var publicId by Bulls.publicId
    var name by Bulls.name
    var number by Bulls.number
    //todo val cows by Cow referrersOn Cows.bull

    fun data(): BullData {
        return BullData(publicId, name, number)
    }
}

//todo object Mate(publicId: String, val date: Date, val cow: Cow, val bull: Bull)
//todo object Lactation(publicId: String, val number: String, val date: Date, val cow: Cow)

object Modules : IdTable<Int>("MODULE") {
    override val id: Column<EntityID<Int>> = integer("ID").autoIncrement().primaryKey().entityId()
    val publicId = varchar("PUBLIC_ID", 36)
    val name = varchar("NAME", 255)
    val description = varchar("DESCRIPTION", 255)
    val image = varchar("IMAGE", 255)
    val action = enumeration("ACTION", Module.Action::class.java)
}

class Module(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Module>(Modules)

    var action by Modules.action
    var publicId by Modules.publicId
    var name by Modules.name
    var description by Modules.description
    var image by Modules.image

    enum class Action {
        ADD_COW,
        ADD_BULL,
        VIEW_COWS,
        VIEW_BULLS
    }

    fun data(): ModuleData {
        return ModuleData(publicId, name, description, image, action)
    }
}
package app.estat.desktop.model

import org.joda.time.DateTime

interface Data

data class ModuleData(val name: String, val description: String, val image: String, val action: Module.Action) : Data

data class CowData(val name: String, val number: String, val birthday: DateTime, val book: Cow.Book) : Data {
    constructor() : this("", "", DateTime.now(), Cow.Book.UNKNOWN)
}

data class BullData(val name: String, val number: String) : Data {
    constructor() : this("", "")
}
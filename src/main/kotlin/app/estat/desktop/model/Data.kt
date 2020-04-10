package app.estat.desktop.model

import java.time.LocalDate

interface Data

data class ModuleData(val publicId: String, val name: String, val description: String, val image: String, val action: Module.Action) : Data

data class CowData(val publicId: String = "", val name: String = "", val number: String = "", val birthday: LocalDate = LocalDate.now(), val book: Cow.Book = Cow.Book.UNKNOWN) : Data

data class BullData(val publicId: String = "", val name: String = "", val number: String = "") : Data
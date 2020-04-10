package app.estat.desktop.model

import tornadofx.*
import java.util.*

class CowViewData(cowData: CowData) : ItemViewModel<CowData>(cowData) {
    val name = bind(CowData::name)
    val number = bind(CowData::number)
    val birthday = bind(CowData::birthday)
    val book = bind(CowData::book)
    val publicId = bind(CowData::publicId)

    override fun onCommit() {
        item = CowData(UUID.randomUUID().toString(), name.value, number.value, birthday.value, book.value)
    }
}

class BullViewData(bullData: BullData) : ItemViewModel<BullData>(bullData) {
    val name = bind(BullData::name)
    val number = bind(BullData::number)
    val publicId = bind(BullData::publicId)

    override fun onCommit() {
        item = BullData(UUID.randomUUID().toString(), name.value, number.value)
    }
}
package app.estat.desktop.model

import tornadofx.*

class CowViewData(cowData: CowData) : ItemViewModel<CowData>(cowData) {
    val name = bind(CowData::name)
    val number = bind(CowData::number)
    val birthday = bind(CowData::birthday)
    val book = bind(CowData::book)

    override fun onCommit() {
        item = CowData(name.value, number.value, birthday.value, book.value)
    }
}

class BullViewData(bullData: BullData) : ItemViewModel<BullData>(bullData) {
    val name = bind(BullData::name)
    val number = bind(BullData::number)

    override fun onCommit() {
        item = BullData(name.value, number.value)
    }
}
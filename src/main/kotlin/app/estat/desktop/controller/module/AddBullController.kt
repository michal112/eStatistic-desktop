package app.estat.desktop.controller.module

import app.estat.desktop.Cache
import app.estat.desktop.model.BullData
import app.estat.desktop.model.BullViewData
import app.estat.desktop.model.CowData
import app.estat.desktop.model.CowViewData
import tornadofx.*

class AddBullController : Controller() {
    val bullViewData = BullViewData(BullData())

    fun addBull() {
        bullViewData.commit()
        Cache.putBull(bullViewData.item)
    }
}
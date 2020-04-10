package app.estat.desktop.controller.module

import app.estat.desktop.Cache
import app.estat.desktop.model.BullData
import app.estat.desktop.model.BullViewData
import tornadofx.*
import java.util.*

class AddBullController : Controller() {
    val bullViewData = BullViewData(BullData())

    fun addBull() {
        Cache.putBull(bullViewData.item)
    }
}
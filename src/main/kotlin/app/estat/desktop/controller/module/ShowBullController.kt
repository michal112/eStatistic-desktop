package app.estat.desktop.controller.module

import app.estat.desktop.Cache
import app.estat.desktop.model.BullViewData
import tornadofx.*

class ShowBullController : Controller() {
    lateinit var bullViewData: BullViewData

    fun deleteBull() {
        Cache.removeBull(bullViewData.publicId.value)
    }
}
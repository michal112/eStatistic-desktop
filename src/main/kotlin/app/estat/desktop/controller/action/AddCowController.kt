package app.estat.desktop.controller.action

import app.estat.desktop.Cache
import app.estat.desktop.model.CowData
import app.estat.desktop.model.CowViewData
import tornadofx.*

class AddCowController : Controller() {
    val cowViewData = CowViewData(CowData())

    fun addCow() {
        cowViewData.commit()
        Cache.putCow(cowViewData.item)
    }
}
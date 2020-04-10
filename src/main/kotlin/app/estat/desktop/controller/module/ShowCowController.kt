package app.estat.desktop.controller.module

import app.estat.desktop.Cache
import app.estat.desktop.model.CowViewData
import tornadofx.*

class ShowCowController : Controller() {
    lateinit var cowViewData: CowViewData

    fun deleteCow() {
        Cache.removeCow(cowViewData.publicId.value)
    }
}
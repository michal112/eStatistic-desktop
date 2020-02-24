package app.estat.desktop.controller.module

import app.estat.desktop.delegation.CowDelegation
import tornadofx.*

class ManageCowsController : Controller() {
    val cows by CowDelegation()
}

package app.estat.desktop.controller.dashboard

import app.estat.desktop.delegation.ModuleDelegation
import tornadofx.*

class DashboardController : Controller() {
    val modules by ModuleDelegation()
}
package app.estat.desktop.controller.module

import app.estat.desktop.delegation.BullDelegation
import tornadofx.*

class ManageBullsController : Controller() {
    val bulls by BullDelegation()
}

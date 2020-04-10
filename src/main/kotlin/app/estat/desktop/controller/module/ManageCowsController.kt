package app.estat.desktop.controller.module

import app.estat.desktop.delegation.CowDelegation
import app.estat.desktop.model.Cow
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import tornadofx.*

class ManageCowsController : Controller() {
    val cows by CowDelegation()
}

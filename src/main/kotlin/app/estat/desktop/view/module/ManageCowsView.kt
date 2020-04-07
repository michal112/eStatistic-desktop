package app.estat.desktop.view.module

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.cow
import app.estat.desktop.controller.module.ManageCowsController
import tornadofx.*

class ManageCowsView : View() {
    val controller: ManageCowsController by inject()

    override val root = vbox {
        addClass(MyStyles.manageCowsView)
        for (cow in controller.cows) {
            cow(this) {
                name { cow.name }
                number { cow.number }
            }
        }
    }
}

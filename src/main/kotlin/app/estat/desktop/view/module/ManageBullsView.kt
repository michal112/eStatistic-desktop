package app.estat.desktop.view.module

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.bull
import app.estat.desktop.controller.module.ManageBullsController
import tornadofx.*

class ManageBullsView : View() {
    val controller: ManageBullsController by inject()

    override val root = vbox {
        addClass(MyStyles.manageBullsView)
        for (bull in controller.bulls) {
            bull(this) {
                name { bull.name }
                number { bull.number }
            }
        }
    }
}

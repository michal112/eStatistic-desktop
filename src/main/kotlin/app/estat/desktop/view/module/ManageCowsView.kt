package app.estat.desktop.view.module

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.back
import app.estat.desktop.comp.cow
import app.estat.desktop.controller.module.ManageCowsController
import app.estat.desktop.model.CowViewData
import app.estat.desktop.view.dashboard.DashboardView
import tornadofx.*

class ManageCowsView : View() {
    val controller: ManageCowsController by inject()

    override val root = hbox {
        vbox {
            addClass(MyStyles.backViewContainer)
            back(this) {
                back { replaceWith<DashboardView>() }
            }
        }
        vbox {
            addClass(MyStyles.manageCowsView)
            children.bind(controller.cows) {
                cow {
                    name { it.name }
                    number { it.number }
                }.apply {
                    onLeftClick {
                        find<ShowCowView>(Scope(CowViewData(it))).openModal()
                    }
                }
            }
        }
    }
}

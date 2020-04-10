package app.estat.desktop.view.module

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.back
import app.estat.desktop.comp.bull
import app.estat.desktop.controller.module.ManageBullsController
import app.estat.desktop.model.BullViewData
import app.estat.desktop.view.dashboard.DashboardView
import tornadofx.*

class ManageBullsView : View() {
    val controller: ManageBullsController by inject()

    override val root = hbox {
        vbox {
            addClass(MyStyles.backViewContainer)
            back(this) {
                back { replaceWith<DashboardView>() }
            }
        }
        vbox {
            addClass(MyStyles.manageBullsView)
            children.bind(controller.bulls) {
                bull {
                    name { it.name }
                    number { it.number }
                }.apply {
                    onLeftClick {
                        find<ShowBullView>(Scope(BullViewData(it))).openModal()
                    }
                }
            }
        }
    }
}

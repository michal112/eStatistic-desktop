package app.estat.desktop.view.dashboard

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.module
import app.estat.desktop.controller.dashboard.DashboardController
import app.estat.desktop.model.Module
import app.estat.desktop.view.module.AddBullView
import app.estat.desktop.view.module.AddCowView
import app.estat.desktop.view.module.ManageBullsView
import app.estat.desktop.view.module.ManageCowsView
import tornadofx.*

class DashboardView : View() {
    val controller: DashboardController by inject()

    override val root = vbox {
        addClass(MyStyles.dashboardView)
        children.bind(controller.modules) {
            module {
                name { it.name }
                description { it.description }
                image { it.image }
            }.apply {
                onLeftClick {
                    when (it.action) {
                        Module.Action.ADD_COW -> replaceWith<AddCowView>()
                        Module.Action.VIEW_COWS -> replaceWith<ManageCowsView>()
                        Module.Action.ADD_BULL -> replaceWith<AddBullView>()
                        Module.Action.VIEW_BULLS -> replaceWith<ManageBullsView>()
                    }
                }
            }
        }
    }
}

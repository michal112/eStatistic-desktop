package app.estat.desktop.view.dashboard

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.module
import app.estat.desktop.controller.dashboard.DashboardController
import app.estat.desktop.model.Module
import app.estat.desktop.view.module.AddCowView
import app.estat.desktop.view.module.ManageCowsView
import javafx.beans.property.Property
import javafx.collections.FXCollections
import tornadofx.*

class DashboardView : View() {
    val controller: DashboardController by inject()

    override val root = vbox {
        addClass(MyStyles.dashboardView)
        for (module in controller.modules) {
            module(this) {
                name { module.name }
                description { module.description }
                image { module.image }
            }.onLeftClick {
                    when(module.action) {
                        Module.Action.ADD_COW -> replaceWith<AddCowView>()
                        Module.Action.VIEW_COWS -> replaceWith<ManageCowsView>()
                        Module.Action.ADD_BULL -> replaceWith<AddCowView>()
                        Module.Action.VIEW_BULLS -> replaceWith<ManageCowsView>()
                    }
            }
        }
    }
}

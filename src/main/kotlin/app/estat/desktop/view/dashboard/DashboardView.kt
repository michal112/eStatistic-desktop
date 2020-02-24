package app.estat.desktop.view.dashboard

import app.estat.desktop.app.MyStyles
import app.estat.desktop.controller.dashboard.DashboardController
import app.estat.desktop.model.Module
import app.estat.desktop.view.action.AddCowView
import app.estat.desktop.view.module.ManageCowsView
import javafx.collections.FXCollections
import tornadofx.*

class DashboardView : View() {
    val controller: DashboardController by inject()

    override val root = listview(FXCollections.observableArrayList(controller.modules)) {
        cellFormat { module ->
            graphic = hbox {
                addClass(MyStyles.moduleItem)
                imageview(module.image) {
                    setFitHeight(40.0)
                    setPreserveRatio(true)
                }
                vbox {
                    label {
                        text = module.name
                        addClass(MyStyles.moduleItemName)
                    }
                    label {
                        text = module.description
                        addClass(MyStyles.moduleItemDescription)
                    }
                }
            }
        }
        onUserSelect { module ->
            when(module.action) {
                Module.Action.ADD_COW -> replaceWith<AddCowView>()
                Module.Action.VIEW_COWS -> replaceWith<ManageCowsView>()
            }
        }
    }
}

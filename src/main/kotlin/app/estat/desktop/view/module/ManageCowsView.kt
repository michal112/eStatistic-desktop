package app.estat.desktop.view.module

import app.estat.desktop.app.MyStyles
import app.estat.desktop.controller.module.ManageCowsController
import javafx.collections.FXCollections
import tornadofx.*

class ManageCowsView : View() {
    companion object {
        const val IMAGE_PATH: String = "/ic_my_cows.png"
    }
    val controller: ManageCowsController by inject()

    override val root = listview(FXCollections.observableArrayList(controller.cows)) {
        cellFormat { cow ->
            graphic = hbox {
                addClass(MyStyles.cowItem)
                imageview(IMAGE_PATH) {
                    setFitHeight(40.0)
                    setPreserveRatio(true)
                }
                vbox {
                    label {
                        text = cow.name
                        addClass(MyStyles.cowItemName)
                    }
                    label {
                        text = cow.number
                        addClass(MyStyles.cowItemNumber)
                    }
                }
            }
        }
        onUserSelect { cow ->

        }
    }
}

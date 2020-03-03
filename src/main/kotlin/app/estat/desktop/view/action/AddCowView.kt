package app.estat.desktop.view.action

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.card
import app.estat.desktop.comp.edittext
//import app.estat.desktop.comp.edittext
import app.estat.desktop.controller.action.AddCowController
import app.estat.desktop.model.CowData
import javafx.collections.FXCollections
import tornadofx.*

class AddCowView : View() {
    companion object {
        const val NAME_IMAGE_PATH = "/ic_name.png"
        const val NAME_HINT = "Nazwa"
        const val NUMBER_IMAGE_PATH = "/ic_number.png"
        const val NUMBER_HINT = "Numer"
        const val ADD_BUTTON_TEXT = "Dodaj krowę"
    }
    val addCowController: AddCowController by inject()

    override val root = vbox {
        addClass(MyStyles.addViewCowContainer)
        card(this) {

            title { "Dane krowy" }
            content {
                vbox {
                    edittext(this) {
                        image { NAME_IMAGE_PATH }
                        hint { NAME_HINT }
                        bind { addCowController.cowViewData.name }
                    }
                    edittext(this) {
                        image { NUMBER_IMAGE_PATH }
                        hint { NUMBER_HINT }
                        bind { addCowController.cowViewData.number }
                    }

                    button {
                        text = ADD_BUTTON_TEXT
                        onLeftClick {
                            addCowController.addCow()
                        }
                    }
                }
            }
        }
    }
}

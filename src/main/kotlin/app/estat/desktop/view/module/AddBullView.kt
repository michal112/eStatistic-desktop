package app.estat.desktop.view.module

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.card
import app.estat.desktop.comp.combobox
import app.estat.desktop.comp.datepicker
import app.estat.desktop.comp.edittext
import app.estat.desktop.controller.module.AddCowController
import app.estat.desktop.model.Cow
import tornadofx.*

class AddBullView : View() {
    companion object {
        const val NAME_IMAGE_PATH = "/ic_name.png"
        const val NAME_HINT = "Nazwa"
        const val NUMBER_IMAGE_PATH = "/ic_number.png"
        const val NUMBER_HINT = "Numer"
        const val ADD_BUTTON_TEXT = "Dodaj buhaja"
        const val COW_DATA_TITLE = "Dane buhaja"
    }
    val addCowController: AddCowController by inject()

    override val root = vbox {
        addClass(MyStyles.addCowViewContainer)
        card(this) {

            title { COW_DATA_TITLE }
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
                    addClass(MyStyles.addBullViewButtonContainer)
                    button {
                        addClass(MyStyles.addBullViewButton)
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

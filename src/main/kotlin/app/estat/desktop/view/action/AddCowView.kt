package app.estat.desktop.view.action

import app.estat.desktop.comp.card
import app.estat.desktop.comp.edittext
import app.estat.desktop.controller.action.AddCowController
import tornadofx.*

class AddCowView : View() {
    companion object {
        const val NAME_IMAGE_PATH = "/ic_name.png"
        const val NAME_HINT = "nazwa"
    }
    val addCowController: AddCowController by inject()

    override val root = vbox {
        card(this) {

            title {
                "Dane krowy"
            }
            node {
                edittext {
                    image { NAME_IMAGE_PATH }
                    hint { NAME_HINT }
                }
            }
        }
    }
}

package app.estat.desktop.view.module

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.card
import app.estat.desktop.comp.combobox
import app.estat.desktop.comp.datepicker
import app.estat.desktop.comp.edittext
import app.estat.desktop.controller.module.AddCowController
import app.estat.desktop.model.Cow
import tornadofx.*

class AddCowView : View() {
    companion object {
        const val BIRTHDAY_IMAGE_PATH = "/ic_calendar.png"
        const val BOOK_IMAGE_PATH = "/ic_book.png"
        const val NAME_IMAGE_PATH = "/ic_name.png"
        const val NAME_HINT = "Nazwa"
        const val NUMBER_IMAGE_PATH = "/ic_number.png"
        const val NUMBER_HINT = "Numer"
        const val ADD_BUTTON_TEXT = "Dodaj krowę"
        const val COW_DATA_TITLE = "Dane krowy"
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
                    combobox(this) {
                        image { BOOK_IMAGE_PATH }
                        items { Cow.Book.values().toList() }
                        bind { addCowController.cowViewData.book }
                    }
                    datepicker(this) {
                        image { BIRTHDAY_IMAGE_PATH }
                        bind { addCowController.cowViewData.birthday }
                    }
                    addClass(MyStyles.addCowViewButtonContainer)
                    button {
                        addClass(MyStyles.addCowViewButton)
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

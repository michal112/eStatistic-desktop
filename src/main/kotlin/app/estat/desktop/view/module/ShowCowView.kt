package app.estat.desktop.view.module

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.card
import app.estat.desktop.comp.delete
import app.estat.desktop.comp.text
import app.estat.desktop.controller.module.ShowCowController
import app.estat.desktop.model.CowViewData
import tornadofx.*
import java.time.format.DateTimeFormatter

class ShowCowView : View() {
    companion object {
        const val BIRTHDAY_IMAGE_PATH = "/ic_calendar.png"
        const val BIRTHDAY_TITLE = "Data urodzenia"
        const val BOOK_IMAGE_PATH = "/ic_book.png"
        const val BOOK_TITLE = "Księga"
        const val NAME_IMAGE_PATH = "/ic_name.png"
        const val NAME_TITLE = "Nazwa"
        const val NUMBER_IMAGE_PATH = "/ic_number.png"
        const val NUMBER_TITLE = "Numer"
        const val COW_DATA_TITLE = "Dane krowy"
    }
    val controller: ShowCowController by inject()
    val cowViewData: CowViewData by inject()

    init {
        controller.cowViewData = cowViewData
    }

    override val root = hbox {
        setPrefSize(512.0, 410.0)
        vbox {
            delete(this) {
                addClass(MyStyles.deleteViewContainer)
                delete {
                    controller.deleteCow()
                    close()
                }
            }
        }
        vbox {
            addClass(MyStyles.showCowViewContainer)
            card(this) {
                title { COW_DATA_TITLE }
                content {
                    vbox {
                        text(this) {
                            image { NAME_IMAGE_PATH }
                            title { NAME_TITLE }
                            value { controller.cowViewData.name.value }
                        }
                        text(this) {
                            image { NUMBER_IMAGE_PATH }
                            title { NUMBER_TITLE }
                            value { controller.cowViewData.number.value }
                        }
                        text(this) {
                            image { BOOK_IMAGE_PATH }
                            title { BOOK_TITLE }
                            value { controller.cowViewData.book.value.name }
                        }
                        text(this) {
                            image { BIRTHDAY_IMAGE_PATH }
                            title { BIRTHDAY_TITLE }
                            value { controller.cowViewData.birthday.value.format(DateTimeFormatter.ISO_DATE) }
                        }
                    }
                }
            }
        }
    }
}
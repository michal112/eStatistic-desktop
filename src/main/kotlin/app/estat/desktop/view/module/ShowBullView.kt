package app.estat.desktop.view.module

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.card
import app.estat.desktop.comp.delete
import app.estat.desktop.comp.text
import app.estat.desktop.controller.module.ShowBullController
import app.estat.desktop.model.BullViewData
import tornadofx.*

class ShowBullView : View() {
    companion object {
        const val NAME_IMAGE_PATH = "/ic_name.png"
        const val NAME_TITLE = "Nazwa"
        const val NUMBER_IMAGE_PATH = "/ic_number.png"
        const val NUMBER_TITLE = "Numer"
        const val COW_DATA_TITLE = "Dane buhaja"
    }
    val controller: ShowBullController by inject()
    val bullViewData: BullViewData by inject()

    init {
        controller.bullViewData = bullViewData
    }

    override val root = hbox {
        setPrefSize(512.0, 410.0)
        vbox {
            delete(this) {
                addClass(MyStyles.deleteViewContainer)
                delete {
                    controller.deleteBull()
                    close()
                }
            }
        }
        vbox {
            addClass(MyStyles.showBullViewContainer)
            card(this) {
                title { COW_DATA_TITLE }
                content {
                    vbox {
                        text(this) {
                            image { NAME_IMAGE_PATH }
                            title { NAME_TITLE }
                            value { controller.bullViewData.name.value }
                        }
                        text(this) {
                            image { NUMBER_IMAGE_PATH }
                            title { NUMBER_TITLE }
                            value { controller.bullViewData.number.value }
                        }
                    }
                }
            }
        }
    }
}
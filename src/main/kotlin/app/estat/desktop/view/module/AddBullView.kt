package app.estat.desktop.view.module

import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.back
import app.estat.desktop.comp.card
import app.estat.desktop.comp.edittext
import app.estat.desktop.controller.module.AddBullController
import app.estat.desktop.view.dashboard.DashboardView
import tornadofx.*

class AddBullView : View() {
    companion object {
        const val NAME_IMAGE_PATH = "/ic_name.png"
        const val NAME_HINT = "Nazwa"
        const val NUMBER_IMAGE_PATH = "/ic_number.png"
        const val NUMBER_HINT = "Numer"
        const val ADD_BUTTON_TEXT = "Dodaj buhaja"
        const val BULL_DATA_TITLE = "Dane buhaja"
    }
    val controller: AddBullController by inject()

    override val root = hbox {
        vbox {
            addClass(MyStyles.backViewContainer)
            back(this) {
                back { replaceWith<DashboardView>() }
            }
        }
        vbox {
            addClass(MyStyles.addBullViewContainer)
            card(this) {
                title { BULL_DATA_TITLE }
                content {
                    vbox {
                        edittext(this) {
                            image { NAME_IMAGE_PATH }
                            hint { NAME_HINT }
                            bind { controller.bullViewData.name }
                        }
                        edittext(this) {
                            image { NUMBER_IMAGE_PATH }
                            hint { NUMBER_HINT }
                            bind { controller.bullViewData.number }
                        }
                        hbox {
                            addClass(MyStyles.addBullViewButtonContainer)
                            button {
                                addClass(MyStyles.addBullViewButton)
                                text = ADD_BUTTON_TEXT
                                onLeftClick {
                                    controller.bullViewData.commit {
                                        controller.addBull()
                                        replaceWith<DashboardView>()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

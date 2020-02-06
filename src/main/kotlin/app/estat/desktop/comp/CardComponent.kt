package app.estat.desktop.comp

import app.estat.desktop.model.Module
import javafx.scene.layout.HBox
import tornadofx.*

class Card(val module: Module) : HBox() {
    init {
        with(this) {
            hbox {
                imageview {

                }
                vbox {
                    label(module.name) {
                        
                    }
                    label(module.description) {

                    }
                }
            }
        }
    }
}
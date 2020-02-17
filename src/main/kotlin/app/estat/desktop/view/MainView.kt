package app.estat.desktop.view

import app.estat.desktop.Cache
import app.estat.desktop.app.MyStyles
import app.estat.desktop.comp.moduleComponent
import tornadofx.*

class MainView: View() {
    val cache: Cache = Cache
    init {
        cache.fetchModules()
    }
    override val root = vbox {
        scrollpane {
            vbox {
                    moduleComponent(this) {

                    }
                }
            }
        }
    }

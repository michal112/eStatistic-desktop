package app.estat.desktop.app

import app.estat.desktop.view.MainView
import javafx.scene.paint.Color
import tornadofx.*

class MyApp: App(MainView::class, MyStyles::class)

class MyStyles : Stylesheet() {
    companion object {
        val moduleComponent by cssclass()
        val itemName by cssclass()
    }
}
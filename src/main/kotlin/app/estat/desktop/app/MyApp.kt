package app.estat.desktop.app

import app.estat.desktop.view.MainView
import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import tornadofx.*

class MyApp: App(MainView::class, MyStyles::class)

class MyStyles : Stylesheet() {
    companion object {
        val header by cssclass()
        val headerImage by cssclass()
        val headerCircle by cssclass()
        val moduleItemName by cssclass()
        val moduleItemDescription by cssclass()
        val moduleItem by cssclass()
        val cowItem by cssclass()
        val cowItemName by cssclass()
        val cowItemNumber by cssclass()
        val editTextView by cssclass()
        val editTextViewImage by cssclass()
        val editTextViewField by cssclass()
    }

    init {
        root {
            prefHeight = 700.px
            prefWidth =  512.px
            fontFamily = "Courier New"
        }
        //header
        header {
            minHeight = 325.px
            minWidth = 512.px
        }
        headerImage {
            minHeight = 290.px
            minWidth = 512.px
        }
        headerCircle {
            maxHeight = 42.px
            maxWidth = 42.px
        }
        //module list item
        moduleItemName {
            fontSize = 14.pt
            fontWeight = FontWeight.BOLD
            padding = box(0.px, 14.px)
        }
        moduleItemDescription {
            fontSize = 10.pt
            padding = box(0.px, 14.px)
        }
        moduleItem {
            minHeight = 55.px
            maxHeight = 55.px
            padding = box(5.px)
        }
        //cow list item
        cowItem {
            minHeight = 55.px
            maxHeight = 55.px
            padding = box(5.px)
        }
        cowItemName {
            fontSize = 14.pt
            fontWeight = FontWeight.BOLD
            padding = box(0.px, 14.px)
        }
        cowItemNumber {
            fontSize = 8.pt
            padding = box(0.px, 14.px)
            alignment = Pos.BOTTOM_RIGHT
        }
        //components
        //edit text view
    }
}
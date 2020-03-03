package app.estat.desktop.app

import app.estat.desktop.view.MainView
import javafx.geometry.Pos
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class MyApp: App(MainView::class, MyStyles::class)

class MyStyles : Stylesheet() {
    companion object {
        val addViewCowContainer by cssclass()
        val moduleItemName by cssclass()
        val moduleItemDescription by cssclass()
        val moduleItem by cssclass()
        val cowItem by cssclass()
        val cowItemName by cssclass()
        val cowItemNumber by cssclass()

        //component
        val editTextView by cssclass()
        val editTextViewImageContainer by cssclass()
        val editTextViewImage by cssclass()
        val editTextViewFieldContainer by cssclass()
        val editTextViewField by cssclass()

        val cardView by cssclass()
        val cardViewLabelContainer by cssclass()
    }

    init {
        root {
            prefHeight = 700.px
            prefWidth =  512.px
            fontFamily = "Courier New"
        }
        //module list item
        moduleItemName {
            fontSize = 14.pt
            fontWeight = FontWeight.BOLD
            padding = box(2.px, 14.px)
        }
        moduleItemDescription {
            fontSize = 10.pt
            padding = box(2.px, 14.px)
        }
        moduleItem {
            minHeight = 63.px
            maxHeight = 63.px
            padding = box(5.px)
            effect = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 255, 0.15), 6.0, 0.7, 0.0, 1.5)
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
        addViewCowContainer {
            padding = box(16.px, 32.px)
        }
        
        //components
        //edit text view
        editTextView {
            padding = box(16.px, 0.px)
        }

        editTextViewImageContainer {
            alignment = Pos.CENTER
            minWidth = 96.px
        }

        editTextViewImage {}

        editTextViewFieldContainer {
            alignment = Pos.CENTER
            minWidth = 288.px
        }

        editTextViewField {
            minWidth = 224.px
        }

        cardView {
            backgroundColor = multi(Color.WHITE)
            backgroundRadius = multi(box(4.px))
            effect = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.15), 6.0, 0.7, 0.0, 1.5)
            padding = box(16.px)
        }

        cardViewLabelContainer {
            fontSize = 14.px
            padding = box(3.px, 16.px)
            alignment = Pos.BASELINE_RIGHT
        }
    }
}
package app.estat.desktop.app

import app.estat.desktop.view.MainView
import javafx.geometry.Pos
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*
import javax.swing.GroupLayout

class MyApp: App(MainView::class, MyStyles::class)

fun main(args: Array<String>) {
    launch<MyApp>(args)
}

class MyStyles : Stylesheet() {
    companion object {
        val dashboardView by cssclass()
        val addCowViewContainer by cssclass()
        val addCowViewButton by cssclass()
        val addCowViewButtonContainer by cssclass()

        //component
        val moduleView by cssclass()
        val moduleViewName by cssclass()
        val moduleViewDescription by cssclass()

        val animalView by cssclass()
        val animalViewName by cssclass()
        val animalViewNumber by cssclass()

        val comboBoxView by cssclass()
        val comboBoxViewImageContainer by cssclass()
        val comboBoxViewContainer by cssclass()
        val comboBoxViewComboBox by cssclass()

        val datePickerView by cssclass()
        val datePickerViewImageContainer by cssclass()
        val datePickerViewContainer by cssclass()
        val datePickerViewDatePicker by cssclass()

        val editTextView by cssclass()
        val editTextViewImageContainer by cssclass()
        val editTextViewFieldContainer by cssclass()
        val editTextViewField by cssclass()

        val cardView by cssclass()
        val cardViewLabelContainer by cssclass()
    }

    init {
        root {
            fontFamily = "Courier New"
        }

        dashboardView {
            spacing = 16.px
            padding = box(16.px, 32.px)
        }
        addCowViewContainer {
            padding = box(16.px, 32.px)
        }
        addCowViewButton {
            padding = box(8.px, 16.px)
        }
        addCowViewButtonContainer {
            alignment = Pos.BASELINE_RIGHT
            minWidth = 272.px
            padding = box(16.px, 4.px)
        }

        //components
        //module view
        moduleViewName {
            fontSize = 14.pt
            fontWeight = FontWeight.BOLD
            padding = box(2.px, 14.px)
        }
        moduleViewDescription {
            fontSize = 10.pt
            padding = box(2.px, 14.px)
        }
        moduleView {
            backgroundColor = multi(Color.WHITE)
            backgroundRadius = multi(box(4.px))
            effect = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.15), 6.0, 0.7, 0.0, 1.5)
            minHeight = 63.px
            maxHeight = 63.px
            padding = box(5.px)
            alignment = Pos.CENTER_LEFT
        }


        //animal view
        animalView {
            backgroundColor = multi(Color.WHITE)
            backgroundRadius = multi(box(4.px))
            effect = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.15), 6.0, 0.7, 0.0, 1.5)
            minHeight = 55.px
            maxHeight = 55.px
            padding = box(5.px)
            alignment = Pos.CENTER_LEFT
        }
        animalViewName {
            fontSize = 14.pt
            fontWeight = FontWeight.BOLD
            padding = box(1.px, 14.px)
        }
        animalViewNumber {
            fontSize = 8.pt
            padding = box(1.px, 14.px)
            alignment = Pos.BOTTOM_RIGHT
        }

        //combo box view
        comboBoxView {
            padding = box(16.px, 0.px)
        }
        comboBoxViewImageContainer {
            alignment = Pos.CENTER
            minWidth = 96.px
        }
        comboBoxViewContainer {
            alignment = Pos.CENTER
            minWidth = 288.px
        }
        comboBoxViewComboBox {
            minWidth = 224.px
        }

        //date picker view
        datePickerView {
            padding = box(16.px, 0.px)
        }
        datePickerViewImageContainer {
            alignment = Pos.CENTER
            minWidth = 96.px
        }
        datePickerViewContainer {
            alignment = Pos.CENTER
            minWidth = 288.px
        }
        datePickerViewDatePicker {
            minWidth = 224.px
        }

        //edit text view
        editTextView {
            padding = box(16.px, 0.px)
        }
        editTextViewImageContainer {
            alignment = Pos.CENTER
            minWidth = 96.px
        }
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
package app.estat.desktop.app

import app.estat.desktop.view.MainView
import javafx.application.Application
import javafx.geometry.Pos
import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class MyApp: App(MainView::class, MyStyles::class)

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}

class MyStyles : Stylesheet() {
    companion object {
        val dashboardView by cssclass()

        val manageCowsView by cssclass()

        val manageBullsView by cssclass()

        val showCowViewContainer by cssclass()

        val showBullViewContainer by cssclass()

        val addCowViewContainer by cssclass()
        val addCowViewButton by cssclass()
        val addCowViewButtonContainer by cssclass()

        val addBullViewContainer by cssclass()
        val addBullViewButton by cssclass()
        val addBullViewButtonContainer by cssclass()

        //component
        val moduleView by cssclass()
        val moduleViewNameContainer by cssclass()
        val moduleViewName by cssclass()
        val moduleViewDescription by cssclass()

        val animalView by cssclass()
        val animalViewName by cssclass()
        val animalViewNumber by cssclass()
        val animalViewNameContainer by cssclass()

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

        val backViewContainer by cssclass()
        val backView by cssclass()

        val deleteViewContainer by cssclass()
        val deleteView by cssclass()

        val textView by cssclass()
        val textViewValue by cssclass()
        val textViewTitle by cssclass()
        val textViewFieldContainer by cssclass()
        val textViewImageContainer by cssclass()
    }

    init {
        dashboardView {
            spacing = 16.px
            padding = box(16.px, 32.px)
        }

        manageCowsView {
            spacing = 12.px
            padding = box(16.px, 24.px, 16.px, 0.px)
        }

        manageBullsView {
            spacing = 12.px
            padding = box(16.px, 24.px, 16.px, 0.px)
        }

        showCowViewContainer {
            padding = box(16.px, 24.px, 16.px, 0.px)
        }

        showBullViewContainer {
            padding = box(16.px, 24.px, 16.px, 0.px)
        }

        addCowViewContainer {
            padding = box(16.px, 24.px, 16.px, 0.px)
        }
        addCowViewButton {
            padding = box(8.px, 16.px)
            backgroundColor = multi(Color.LIGHTGRAY)
            backgroundRadius = multi(box(4.px))
            effect = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.15), 6.0, 0.7, 0.0, 1.5)
        }
        addCowViewButtonContainer {
            alignment = Pos.BASELINE_RIGHT
            padding = box(16.px, 4.px)
            fontSize = 10.pt
            fontWeight = FontWeight.BOLD
        }

        addBullViewContainer {
            padding = box(16.px, 24.px, 16.px, 0.px)
        }
        addBullViewButton {
            padding = box(8.px, 16.px)
            backgroundColor = multi(Color.LIGHTGRAY)
            backgroundRadius = multi(box(4.px))
            effect = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.15), 6.0, 0.7, 0.0, 1.5)
        }
        addBullViewButtonContainer {
            alignment = Pos.BASELINE_RIGHT
            padding = box(16.px, 4.px)
            fontSize = 10.pt
            fontWeight = FontWeight.BOLD
        }

        //components
        //module view
        moduleViewNameContainer {
            padding = box(0.px, 0.px, 0.px, 24.px)
            minHeight = 40.px
            maxHeight = 40.px
            minWidth = 360.px
            maxWidth = 360.px
            alignment = Pos.CENTER_LEFT
        }
        moduleViewName {
            fontSize = 14.pt
            fontWeight = FontWeight.BOLD
        }
        moduleViewDescription {
            fontSize = 10.pt
        }
        moduleView {
            backgroundColor = multi(Color.WHITE)
            backgroundRadius = multi(box(4.px))
            effect = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.15), 6.0, 0.7, 0.0, 1.5)
            minHeight = 62.px
            maxHeight = 62.px
            padding = box(0.px, 24.px)
            alignment = Pos.CENTER_LEFT
        }

        //animal view
        animalView {
            backgroundColor = multi(Color.WHITE)
            backgroundRadius = multi(box(4.px))
            effect = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.15), 6.0, 0.7, 0.0, 1.5)
            minHeight = 54.px
            maxHeight = 54.px
            padding = box(0.px, 24.px)
            alignment = Pos.CENTER_LEFT
        }
        animalViewName {
            fontSize = 14.pt
            fontWeight = FontWeight.BOLD
            alignment = Pos.CENTER_LEFT
            minWidth = 324.px
            maxWidth = 324.px
        }
        animalViewNameContainer {
            padding = box(0.px, 0.px, 0.px, 24.px)
            minHeight = 40.px
            maxHeight = 40.px
            minWidth = 352.px
            maxWidth = 352.px
        }
        animalViewNumber {
            alignment = Pos.BOTTOM_RIGHT
            fontSize = 10.pt
            minWidth = 324.px
            maxWidth = 324.px
        }

        //combo box view
        comboBoxView {
            padding = box(16.px, 0.px)
        }
        comboBoxViewImageContainer {
            alignment = Pos.CENTER
            padding = box(0.px, 16.px)
        }
        comboBoxViewContainer {
            alignment = Pos.CENTER
            minWidth = 344.px
        }
        comboBoxViewComboBox {
            minWidth = 312.px
        }

        //date picker view
        datePickerView {
            padding = box(16.px, 0.px)
        }
        datePickerViewImageContainer {
            alignment = Pos.CENTER
            padding = box(0.px, 16.px)
        }
        datePickerViewContainer {
            alignment = Pos.CENTER
            minWidth = 344.px
        }
        datePickerViewDatePicker {
            minWidth = 312.px
        }

        //edit text view
        editTextView {
            padding = box(16.px, 0.px)
        }
        editTextViewImageContainer {
            alignment = Pos.CENTER
            padding = box(0.px, 16.px)
        }
        editTextViewFieldContainer {
            alignment = Pos.CENTER
            padding = box(0.px, 16.px)
            minWidth = 344.px
        }
        editTextViewField {
            minWidth = 312.px
        }

        //card view
        cardView {
            backgroundColor = multi(Color.WHITE)
            backgroundRadius = multi(box(4.px))
            effect = DropShadow(BlurType.GAUSSIAN, Color.rgb(0, 0, 0, 0.15), 6.0, 0.7, 0.0, 1.5)
            padding = box(16.px)
        }
        cardViewLabelContainer {
            fontSize = 10.pt
            padding = box(3.px, 16.px)
            alignment = Pos.BASELINE_RIGHT
        }

        //back view
        backViewContainer {
            padding = box(24.px, 8.px, 8.px, 8.px)
            maxHeight = 64.px
            minHeight = 64.px
            maxWidth = 48.px
            minWidth = 48.px
            alignment = Pos.BOTTOM_CENTER
        }
        backView {
            maxHeight = 32.px
            minHeight = 32.px
            maxWidth = 32.px
            minWidth = 32.px
            backgroundColor = multi(Color.TRANSPARENT)
            borderColor = multi(box(Color.TRANSPARENT))
        }
        backView and focused {
            borderColor = multi(box(Color.TRANSPARENT))
        }
        backView and pressed {
            borderColor = multi(box(Color.TRANSPARENT))
        }

        //delete view
        deleteViewContainer {
            padding = box(24.px, 8.px, 8.px, 8.px)
            maxHeight = 64.px
            minHeight = 64.px
            maxWidth = 48.px
            minWidth = 48.px
            alignment = Pos.BOTTOM_CENTER
        }
        deleteView {
            maxHeight = 32.px
            minHeight = 32.px
            maxWidth = 32.px
            minWidth = 32.px
            backgroundColor = multi(Color.TRANSPARENT)
            borderColor = multi(box(Color.TRANSPARENT))
        }
        deleteView and focused {
            borderColor = multi(box(Color.TRANSPARENT))
        }
        deleteView and pressed {
            borderColor = multi(box(Color.TRANSPARENT))
        }

        //text view
        textView {
            padding = box(16.px, 0.px)
        }
        textViewImageContainer {
            alignment = Pos.CENTER
            padding = box(0.px, 16.px)
        }
        textViewFieldContainer {
            alignment = Pos.CENTER_LEFT
            minWidth = 344.px
            padding = box(0.px, 16.px)
        }
        textViewTitle {
            fontSize = 10.pt
        }
        textViewValue {
            fontSize = 12.pt
        }
    }
}
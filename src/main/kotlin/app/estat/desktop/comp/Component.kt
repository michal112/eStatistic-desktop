package app.estat.desktop.comp

import app.estat.desktop.app.MyStyles
import javafx.beans.property.Property
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import tornadofx.*
//
//class ComboBoxView(image: String) : HBox() {
//
//    init {
//        addClass(MyStyles.editTextView)
//        hbox {
//            addClass(MyStyles.editTextViewImage)
//            imageview(image) {
//                setFitHeight(20.0)
//                setPreserveRatio(true)
//            }
//        }
//        hbox {
//            addClass(MyStyles.editTextViewField)
//            textfield {
//                promptText = hint
//                bind(value)
//            }
//        }
//    }
//}

class EditTextView(image: String, hint: String, value: Property<String>) : HBox() {

    init {
        addClass(MyStyles.editTextView)
        hbox {
            addClass(MyStyles.editTextViewImageContainer)
            imageview(image) {
                addClass(MyStyles.editTextViewImage)
                setFitHeight(30.0)
                setPreserveRatio(true)
            }
        }
        hbox {
            addClass(MyStyles.editTextViewFieldContainer)
            textfield {
                addClass(MyStyles.editTextViewField)
                promptText = hint
                bind(value)
            }
        }
    }

    class EditTextBuilder {
        private lateinit var hint: String

        private lateinit var image: String

        private lateinit var value: Property<String>

        fun hint(action: () -> String) {
            apply { hint = action() }
        }

        fun image(action: () -> String) {
            apply { image = action() }
        }

        fun bind(action: () -> Property<String>) {
            apply { value = action() }
        }

        fun build() : EditTextView {
            return EditTextView(image, hint, value)
        }
    }
}

class CardView(title: String, content: Node) : VBox() {

    init {
        addClass(MyStyles.cardView)
        hbox {
            addClass(MyStyles.cardViewLabelContainer)
            label {
                text = title
            }
        }
        add(content)
    }

    class CardViewBuilder {
        private lateinit var title: String

        private lateinit var content: Node

        fun title(action: () -> String) {
            apply { title = action() }
        }

        fun content(action: () -> Node) {
            apply { content = action() }
        }

        fun build() : CardView {
            return CardView(title, content)
        }
    }
}


fun card(parent: Node?, action: CardView.CardViewBuilder.() -> Unit) : CardView {
    return ComponentFactory.createCardComponent(parent, action)
}

fun edittext(parent: Node?, action: EditTextView.EditTextBuilder.() -> Unit) : EditTextView {
    return ComponentFactory.createEditTextComponent(parent, action)
}
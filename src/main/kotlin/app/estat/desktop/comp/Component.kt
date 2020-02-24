package app.estat.desktop.comp

import app.estat.desktop.app.MyStyles
import app.estat.desktop.model.Module
import javafx.collections.FXCollections
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.control.ListView
import javafx.scene.image.Image
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import tornadofx.*

class EditTextView(image: String, hint: String) : HBox() {

    init {
        addClass(MyStyles.editTextView)
        hbox {
            addClass(MyStyles.editTextViewImage)
            imageview(image) {
                setFitHeight(20.0)
                setPreserveRatio(true)
            }
        }
        hbox {
            addClass(MyStyles.editTextViewField)
            textfield {
                promptText = hint
            }
        }
    }

    class EditTextBuilder {
        private lateinit var hint: String

        private lateinit var image: String

        fun hint(action: () -> String) {
            apply { hint = action() }
        }

        fun image(action: () -> String) {
            apply { image = action() }
        }

        fun build() : EditTextView {
            return EditTextView(image, hint)
        }
    }
}

class CardView(title: String, container: MutableList<Node>) : VBox() {

    init {
        label {
            text {
                text = title
            }
        }
        vbox {
            for (node in container) {
                add(node)
            }
        }
    }

    class CardViewBuilder {
        private lateinit var title: String

        private val container: MutableList<Node> = mutableListOf()

        fun title(action: () -> String) {
            apply { title = action() }
        }

        fun node(action: () -> Node) {
            apply { container.add(action()) }
        }

        fun build() : CardView {
            return CardView(title, container)
        }
    }
}


fun card(parent: Node?, action: CardView.CardViewBuilder.() -> Unit) : CardView {
    return ComponentFactory.createCardComponent(parent, action)
}

fun edittext(action: EditTextView.EditTextBuilder.() -> Unit) : EditTextView {
    return ComponentFactory.createEditTextComponent(action)
}
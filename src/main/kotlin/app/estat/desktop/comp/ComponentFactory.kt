package app.estat.desktop.comp

import javafx.scene.Node
import tornadofx.*

object ComponentFactory {

    fun createCardComponent(parent: Node?, action: CardView.CardViewBuilder.() -> Unit) : CardView {
        val cardView = CardView.CardViewBuilder().apply(action).build()
        parent?.getChildList()?.add(cardView)
        return cardView
    }

    fun createEditTextComponent(parent: Node?, action: EditTextView.EditTextBuilder.() -> Unit) : EditTextView {
        val editTextView = EditTextView.EditTextBuilder().apply(action).build()
        parent?.getChildList()?.add(editTextView)
        return editTextView
    }
}
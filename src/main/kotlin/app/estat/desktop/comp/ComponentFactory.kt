package app.estat.desktop.comp

import app.estat.desktop.model.Cow
import javafx.scene.Node
import tornadofx.*

object ComponentFactory {

    fun createCardComponent(parent: Node?, action: CardView.CardViewBuilder.() -> Unit) : CardView {
        val cardView = CardView.CardViewBuilder().apply(action).build()
        parent?.getChildList()?.add(cardView)
        return cardView
    }

    fun createEditTextComponent(parent: Node?, action: EditTextView.EditTextViewBuilder.() -> Unit) : EditTextView {
        val editTextView = EditTextView.EditTextViewBuilder().apply(action).build()
        parent?.getChildList()?.add(editTextView)
        return editTextView
    }

    fun createModuleComponent(action: ModuleView.ModuleViewBuilder.() -> Unit) : ModuleView {
        return ModuleView.ModuleViewBuilder().apply(action).build()
    }

    fun createCowComponent(action: CowView.CowViewBuilder.() -> Unit) : CowView {
        return CowView.CowViewBuilder().apply(action).build()
    }

    fun createBullComponent(action: BullView.BullViewBuilder.() -> Unit) : BullView {
        return BullView.BullViewBuilder().apply(action).build()
    }

    fun createComboBoxComponent(parent: Node?, action: ComboBoxView.ComboBoxViewBuilder<Cow.Book>.() -> Unit): ComboBoxView<Cow.Book> {
        val comboBoxView = ComboBoxView.ComboBoxViewBuilder<Cow.Book>().apply(action).build()
        parent?.getChildList()?.add(comboBoxView)
        return comboBoxView
    }

    fun createDatePickerComponent(parent: Node?, action: DatePickerView.DatePickerViewBuilder.() -> Unit): DatePickerView {
        val datePickerView = DatePickerView.DatePickerViewBuilder().apply(action).build()
        parent?.getChildList()?.add(datePickerView)
        return datePickerView
    }

    fun createBackComponent(parent: Node?, action: BackView.BackViewBuilder.() -> Unit): BackView {
        val backView = BackView.BackViewBuilder().apply(action).build()
        parent?.getChildList()?.add(backView)
        return backView
    }

    fun createTextComponent(parent: Node?, action: TextView.TextViewBuilder.() -> Unit): TextView {
        val textView = TextView.TextViewBuilder().apply(action).build()
        parent?.getChildList()?.add(textView)
        return textView
    }

    fun createDeleteComponent(parent: Node?, action: DeleteView.DeleteViewBuilder.() -> Unit): DeleteView {
        val deleteView = DeleteView.DeleteViewBuilder().apply(action).build()
        parent?.getChildList()?.add(deleteView)
        return deleteView
    }
}
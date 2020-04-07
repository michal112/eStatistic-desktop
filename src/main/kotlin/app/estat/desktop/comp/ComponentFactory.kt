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

    fun createModuleComponent(parent: Node?, action: ModuleView.ModuleViewBuilder.() -> Unit) : ModuleView {
        val moduleView = ModuleView.ModuleViewBuilder().apply(action).build()
        parent?.getChildList()?.add(moduleView)
        return moduleView
    }

    fun createCowComponent(parent: Node?, action: CowView.CowViewBuilder.() -> Unit) : CowView {
        val cowView = CowView.CowViewBuilder().apply(action).build()
        parent?.getChildList()?.add(cowView)
        return cowView
    }

    fun createBullComponent(parent: Node?, action: BullView.BullViewBuilder.() -> Unit) : BullView {
        val bullView = BullView.BullViewBuilder().apply(action).build()
        parent?.getChildList()?.add(bullView)
        return bullView
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
}
package app.estat.desktop.comp

import app.estat.desktop.app.MyStyles
import app.estat.desktop.model.Cow
import javafx.beans.property.Property
import javafx.collections.FXCollections
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import tornadofx.*
import java.time.LocalDate

abstract class AnimalView(name:String, number: String, image: String) : HBox() {

    init {
        addClass(MyStyles.animalView)
        add(
            imageview(image) {
                setFitHeight(40.0)
                setPreserveRatio(true)
            }
        )
        vbox {
            addClass(MyStyles.animalViewNameContainer)
            label {
                text = name
                addClass(MyStyles.animalViewName)
            }
            hbox {
                label {
                    text = number
                    addClass(MyStyles.animalViewNumber)
                }
            }
        }
    }

    abstract class AnimalViewBuilder<T> {
        protected lateinit var name: String

        protected lateinit var number: String

        fun name(action: () -> String) {
            apply { name = action() }
        }

        fun number(action: () -> String) {
            apply { number = action() }
        }

        abstract fun build(): T
    }
}

class CowView(name: String, description: String) : AnimalView(name, description, IMAGE) {
    companion object {
        const val IMAGE = "/ic_my_cows.png"
    }

    class CowViewBuilder : AnimalViewBuilder<CowView>() {
        override fun build(): CowView {
            return CowView(name, number)
        }
    }
}

class BullView(name: String, description: String) : AnimalView(name, description, IMAGE) {
    companion object {
        const val IMAGE = "/ic_my_bulls.png"
    }

    class BullViewBuilder : AnimalViewBuilder<BullView>() {
        override fun build(): BullView {
            return BullView(name, number)
        }
    }
}

class ModuleView(name: String, description: String, image: String) : HBox() {

    init {
        addClass(MyStyles.moduleView)
        add(
            imageview(image) {
                setFitHeight(40.0)
                setPreserveRatio(true)
            }
        )
        vbox {
            addClass(MyStyles.moduleViewNameContainer)
            label {
                text = name
                addClass(MyStyles.moduleViewName)
            }
            label {
                text = description
                addClass(MyStyles.moduleViewDescription)
            }
        }
    }

    class ModuleViewBuilder {
        private lateinit var name: String

        private lateinit var description: String

        private lateinit var image: String

        fun name(action: () -> String) {
            apply { name = action() }
        }

        fun description(action: () -> String) {
            apply { description = action() }
        }

        fun image(action: () -> String) {
            apply { image = action() }
        }

        fun build() : ModuleView {
            return ModuleView(name, description, image)
        }
    }
}

class DatePickerView(image: String, value: Property<LocalDate>) : HBox() {

    init {
        addClass(MyStyles.datePickerView)
        hbox {
            addClass(MyStyles.datePickerViewImageContainer)
            imageview(image) {
                setFitHeight(32.0)
                setPreserveRatio(true)
            }
        }
        hbox {
            addClass(MyStyles.datePickerViewContainer)
            datepicker {
                addClass(MyStyles.datePickerViewDatePicker)
                bind(value)
            }
        }
    }

    class DatePickerViewBuilder {
        private lateinit var image: String

        private lateinit var value: Property<LocalDate>

        fun image(action: () -> String) {
            apply { image = action() }
        }

        fun bind(action: () -> Property<LocalDate>) {
            apply { value = action() }
        }

        fun build(): DatePickerView {
            return DatePickerView(image, value)
        }
    }
}

class ComboBoxView<T>(image: String, items: List<T>, value: Property<T>) : HBox() {

    init {
        addClass(MyStyles.comboBoxView)
        hbox {
            addClass(MyStyles.comboBoxViewImageContainer)
            imageview(image) {
                setFitHeight(32.0)
                setPreserveRatio(true)
            }
        }
        hbox {
            addClass(MyStyles.comboBoxViewContainer)
            combobox<T> {
                addClass(MyStyles.comboBoxViewComboBox)
                this.items = FXCollections.observableArrayList(items)
                bind(value)
            }
        }
    }

    class ComboBoxViewBuilder<T> {
        private lateinit var items: List<T>

        private lateinit var image: String

        private lateinit var value: Property<T>

        fun items(action: () -> List<T>) {
            apply { items = action() }
        }

        fun image(action: () -> String) {
            apply { image = action() }
        }

        fun bind(action: () -> Property<T>) {
            apply { value = action() }
        }

        fun build() : ComboBoxView<T> {
            return ComboBoxView(image, items, value)
        }
    }
}

class TextView(image: String, title: String, value: String) : HBox() {

    init {
        addClass(MyStyles.textView)
        hbox {
            addClass(MyStyles.textViewImageContainer)
            imageview(image) {
                setFitHeight(32.0)
                setPreserveRatio(true)
            }
        }
        vbox {
            addClass(MyStyles.textViewFieldContainer)
            label {
                addClass(MyStyles.textViewTitle)
                text = title
            }
            label {
                addClass(MyStyles.textViewValue)
                text = value
            }
        }
    }

    class TextViewBuilder {
        private lateinit var title: String

        private lateinit var image: String

        private lateinit var value: String

        fun title(action: () -> String) {
            apply { title = action() }
        }

        fun image(action: () -> String) {
            apply { image = action() }
        }

        fun value(action: () -> String) {
            apply { value = action() }
        }

        fun build() : TextView {
            return TextView(image, title, value)
        }
    }
}

class EditTextView(image: String, hint: String, value: Property<String>) : HBox() {

    init {
        addClass(MyStyles.editTextView)
        hbox {
            addClass(MyStyles.editTextViewImageContainer)
            imageview(image) {
                setFitHeight(32.0)
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

    class EditTextViewBuilder {
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

class BackView(val back: () -> Unit) : Button() {

    companion object {
        const val IMAGE = "/ic_back.png"
    }

    init {
        addClass(MyStyles.backView)
        graphic = imageview(IMAGE) {
            setFitHeight(32.0)
            setPreserveRatio(true)
        }
        onLeftClick {
            back()
        }
    }

    class BackViewBuilder {
        private lateinit var back: () -> Unit

        fun back(action: () -> Unit) {
            apply {
                back = action
            }
        }

        fun build() : BackView {
            return BackView(back)
        }
    }
}

class DeleteView(val delete: () -> Unit) : Button() {

    companion object {
        const val IMAGE = "/ic_delete.png"
    }

    init {
        addClass(MyStyles.deleteView)
        graphic = imageview(IMAGE) {
            setFitHeight(24.0)
            setPreserveRatio(true)
        }
        onLeftClick {
            delete()
        }
    }

    class DeleteViewBuilder {
        private lateinit var delete: () -> Unit

        fun delete(action: () -> Unit) {
            apply {
                delete = action
            }
        }

        fun build() : DeleteView {
            return DeleteView(delete)
        }
    }
}

fun delete(parent: Node?, action: DeleteView.DeleteViewBuilder.() -> Unit) : DeleteView {
    return ComponentFactory.createDeleteComponent(parent, action)
}

fun back(parent: Node?, action: BackView.BackViewBuilder.() -> Unit) : BackView {
    return ComponentFactory.createBackComponent(parent, action)
}

fun datepicker(parent: Node?, action: DatePickerView.DatePickerViewBuilder.() -> Unit) : DatePickerView {
    return ComponentFactory.createDatePickerComponent(parent, action)
}

fun combobox(parent: Node?, action: ComboBoxView.ComboBoxViewBuilder<Cow.Book>.() -> Unit) : ComboBoxView<Cow.Book> {
    return ComponentFactory.createComboBoxComponent(parent, action)
}

fun bull(action: BullView.BullViewBuilder.() -> Unit) : BullView {
    return ComponentFactory.createBullComponent(action)
}

fun cow(action: CowView.CowViewBuilder.() -> Unit) : CowView {
    return ComponentFactory.createCowComponent(action)
}

fun module(action: ModuleView.ModuleViewBuilder.() -> Unit) : ModuleView {
    return ComponentFactory.createModuleComponent(action)
}

fun card(parent: Node?, action: CardView.CardViewBuilder.() -> Unit) : CardView {
    return ComponentFactory.createCardComponent(parent, action)
}

fun edittext(parent: Node?, action: EditTextView.EditTextViewBuilder.() -> Unit) : EditTextView {
    return ComponentFactory.createEditTextComponent(parent, action)
}

fun text(parent: Node?, action: TextView.TextViewBuilder.() -> Unit) : TextView {
    return ComponentFactory.createTextComponent(parent, action)
}
package app.estat.desktop.comp

import app.estat.desktop.model.Module
import javafx.scene.Node
import javafx.scene.layout.VBox
import tornadofx.*

object ComponentFactory {
    fun <T: Node> createComponent(component: T, parent: Node?, action: T.() -> Unit) : T {
        component.action()
        parent?.getChildList()?.add(component)
        return component
    }

    fun createModuleComponent(parent: Node?, action: ModuleComponent.() -> Unit) : ModuleComponent {
        return createComponent(ModuleComponent(), parent, action)
    }

    fun createCardComponent(parent: Node?, action: Card.() -> Unit) : Card {
        return createComponent(Card(), parent, action)
    }
}

class Card : VBox()

fun card(parent: Node?, action: Card.() -> Unit) : Card {
    return ComponentFactory.createCardComponent(parent, action)
}

class ModuleComponent() : VBox() {
    val module: Module
    init {
        hbox {
            text {
                text = module.name
            }
            addClass("mdl-card__title")
        }
        hbox {
            text {
                text = module.description
            }
            addClass("mdl-card__title")
        }

    }
}

fun moduleComponent(parent: Node?, action: ModuleComponent.() -> Unit) : ModuleComponent {
    return ComponentFactory.createModuleComponent(parent, action)
}

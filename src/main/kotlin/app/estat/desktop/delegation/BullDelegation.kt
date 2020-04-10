package app.estat.desktop.delegation

import app.estat.desktop.Cache
import app.estat.desktop.controller.module.ManageBullsController
import app.estat.desktop.model.BullData
import javafx.collections.ObservableList
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class BullDelegation : ReadOnlyProperty<ManageBullsController, ObservableList<BullData>> {
    val cache: Cache = Cache

    override fun getValue(thisRef: ManageBullsController, property: KProperty<*>): ObservableList<BullData> {
        if (cache.bulls.isEmpty()) {
            cache.fetchBulls()
        }
        return cache.bullList
    }
}
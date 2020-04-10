package app.estat.desktop.delegation

import app.estat.desktop.Cache
import app.estat.desktop.controller.module.ManageCowsController
import app.estat.desktop.model.CowData
import javafx.collections.ObservableList
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class CowDelegation : ReadOnlyProperty<ManageCowsController, ObservableList<CowData>> {
    val cache: Cache = Cache

    override fun getValue(thisRef: ManageCowsController, property: KProperty<*>): ObservableList<CowData> {
        if (cache.cows.isEmpty()) {
            cache.fetchCows()
        }
        return cache.cowList
    }
}
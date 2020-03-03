package app.estat.desktop.delegation

import app.estat.desktop.Cache
import app.estat.desktop.controller.module.ManageCowsController
import app.estat.desktop.model.Cow
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class CowDelegation : ReadOnlyProperty<ManageCowsController, List<Cow>> {
    val cache: Cache = Cache

    override fun getValue(thisRef: ManageCowsController, property: KProperty<*>): List<Cow> {
        if (cache.cows.isEmpty()) {
            cache.fetchCows()
        }
        return cache.cows.values.toList()
    }
}
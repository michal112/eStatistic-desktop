package app.estat.desktop.delegation

import app.estat.desktop.Cache
import app.estat.desktop.controller.module.ManageBullsController
import app.estat.desktop.controller.module.ManageCowsController
import app.estat.desktop.db.DbHelper
import app.estat.desktop.model.Bull
import app.estat.desktop.model.Cow
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class BullDelegation : ReadOnlyProperty<ManageBullsController, List<Bull>> {
    val cache: Cache = Cache

    override fun getValue(thisRef: ManageBullsController, property: KProperty<*>): List<Bull> {
        if (cache.bulls.isEmpty()) {
            cache.fetchBulls()
        }
        return cache.bulls
    }
}
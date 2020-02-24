package app.estat.desktop.delegation

import app.estat.desktop.Cache
import app.estat.desktop.controller.dashboard.DashboardController
import app.estat.desktop.db.DbHelper
import app.estat.desktop.model.Module
import java.util.*
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ModuleDelegation : ReadOnlyProperty<DashboardController, List<Module>> {
    val cache: Cache = Cache

    override fun getValue(thisRef: DashboardController, property: KProperty<*>): List<Module> {
        if (cache.modules.isEmpty()) {
            cache.fetchModules()
        }
        return cache.modules
    }
}
package app.estat.desktop.delegation

import app.estat.desktop.Cache
import app.estat.desktop.controller.dashboard.DashboardController
import app.estat.desktop.model.ModuleData
import javafx.collections.ObservableList
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ModuleDelegation : ReadOnlyProperty<DashboardController, ObservableList<ModuleData>> {
    val cache: Cache = Cache

    override fun getValue(thisRef: DashboardController, property: KProperty<*>): ObservableList<ModuleData> {
        if (cache.modules.isEmpty()) {
            cache.fetchModules()
        }
        return cache.moduleList
    }
}
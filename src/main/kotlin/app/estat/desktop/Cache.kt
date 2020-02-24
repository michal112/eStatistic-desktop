package app.estat.desktop

import app.estat.desktop.db.DbHelper
import app.estat.desktop.model.Bull
import app.estat.desktop.model.Cow
import app.estat.desktop.model.Module

object Cache {
    val modules: MutableList<Module> = mutableListOf()
    val cows: MutableList<Cow> = mutableListOf()
    val bulls: MutableList<Bull> = mutableListOf()

    fun fetchModules() {
        modules.clear()
        modules.addAll(DbHelper.getAllModules())
    }

    fun fetchCows() {
        cows.clear()
        cows.addAll(DbHelper.getAllCows())
    }

    fun fetchBulls() {
        bulls.clear()
        bulls.addAll(DbHelper.getAllBulls())
    }
}
package app.estat.desktop

import app.estat.desktop.db.DbHelper
import app.estat.desktop.model.Bull
import app.estat.desktop.model.Cow
import app.estat.desktop.model.CowData
import app.estat.desktop.model.Module

object Cache {
    val modules: MutableMap<String, Module> = mutableMapOf()
    val cows: MutableMap<String, Cow> = mutableMapOf()
    val bulls: MutableMap<String, Bull> = mutableMapOf()

    fun fetchModules() {
        for (module in DbHelper.getAllModules()) {
            modules.putIfAbsent(module.publicId, module)
        }
    }

    fun fetchCows() {
        for (cow in DbHelper.getAllCows()) {
            cows.putIfAbsent(cow.publicId, cow)
        }
    }

    fun fetchBulls() {
        for (bull in DbHelper.getAllBulls()) {
            bulls.putIfAbsent(bull.publicId, bull)
        }
    }

    fun putCow(cowData: CowData) {
//        val cow = DbHelper.createCow(cowData)
//        cows.putIfAbsent(cow.publicId, cow)
    }

    fun removeCow(publicId: String) {
        cows[publicId]?.let { DbHelper.deleteCow(it) }
        cows.remove(publicId)
    }
}
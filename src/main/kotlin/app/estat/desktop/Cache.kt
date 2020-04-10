package app.estat.desktop

import app.estat.desktop.db.DbHelper
import app.estat.desktop.model.*
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import kotlin.collections.set

object Cache {
    val modules: MutableMap<String, Module> = mutableMapOf()
    val cows: MutableMap<String, Cow> = mutableMapOf()
    val bulls: MutableMap<String, Bull> = mutableMapOf()

    val moduleList: ObservableList<ModuleData> = FXCollections.observableArrayList()
    val cowList: ObservableList<CowData> = FXCollections.observableArrayList()
    val bullList: ObservableList<BullData> = FXCollections.observableArrayList()

    fun fetchModules() {
        for (module in DbHelper.getAllModules()) {
            addModule(module)
        }
    }

    fun fetchCows() {
        for (cow in DbHelper.getAllCows()) {
            addCow(cow)
        }
    }

    fun fetchBulls() {
        for (bull in DbHelper.getAllBulls()) {
            addBull(bull)
        }
    }

    fun putCow(cowData: CowData) {
        val cow = DbHelper.createCow(cowData)
        addCow(cow)
    }

    fun putBull(bullData: BullData) {
        val bull = DbHelper.createBull(bullData)
        addBull(bull)
    }

    fun removeCow(publicId: String) {
        cows[publicId]?.let { DbHelper.deleteCow(it) }
        cows.remove(publicId)
        cowList.first { it.publicId == publicId }.let { cowList.remove(it) }
    }

    fun removeBull(publicId: String) {
        bulls[publicId]?.let { DbHelper.deleteBull(it) }
        bulls.remove(publicId)
        bullList.first { it.publicId == publicId }.let { bullList.remove(it) }
    }

    private fun addModule(module: Module) {
        modules[module.publicId] = module
        moduleList.add(module.data())
    }

    private fun addCow(cow: Cow) {
        cows[cow.publicId] = cow
        cowList.add(cow.data())
    }

    private fun addBull(bull: Bull) {
        bulls[bull.publicId] = bull
        bullList.add(bull.data())
    }
}
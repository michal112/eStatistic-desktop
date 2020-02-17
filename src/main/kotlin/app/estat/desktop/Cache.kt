package app.estat.desktop

import app.estat.desktop.model.Module
import java.util.*

object Cache {
    val modules: MutableList<Module> = mutableListOf()


    fun fetchModules() {
        val module = Module(publicId = UUID.randomUUID().toString(), name = "example module name",
                description = " exaample module description" )
        modules.add(module)
    }
}
package app.estat.desktop.db

import app.estat.desktop.model.Module
import app.estat.desktop.model.ModuleData
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

class ModuleDAO : DAO<ModuleData, Module> {
    override fun getAll() : List<Module> {
        val modules = mutableListOf<Module>()
        transaction(DbHelper.db) {
            addLogger(StdOutSqlLogger)
            modules.addAll(Module.all().toList())
        }
        return modules
    }

    override fun create(moduleData: ModuleData) : Module {
        val module: Module by lazy {
            transaction(DbHelper.db) {
                addLogger(StdOutSqlLogger)
                Module.new {
                    publicId = moduleData.publicId
                    name = moduleData.name
                    description = moduleData.description
                    image = moduleData.image
                    action = moduleData.action
                }
            }
        }
        return module
    }

    override fun delete(entity: Module) {
        throw UnsupportedOperationException()
    }
}
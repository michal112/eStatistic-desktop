package app.estat.desktop.db

import app.estat.desktop.model.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

object DbHelper {
    val db by lazy {
        Database.connect(url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
    }
    val moduleDAO: ModuleDAO = ModuleDAO()
    val cowDAO: CowDAO = CowDAO()
    val bullDAO: BullDAO = BullDAO()

    init {
        transaction(db) {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Modules)
        }

        initModules()
    }

    fun initModules() {
        moduleDAO.create(ModuleData(name = "Dodaj buhaja", description = "Dodaj nowego buhaja", image = "/ic_my_bulls_add.png", action = Module.Action.ADD_BULL))
        moduleDAO.create(ModuleData(name = "Dodaj krowę", description = "Dodaj nową krowę", image = "/ic_my_cows_add.png", action = Module.Action.ADD_COW))
        moduleDAO.create(ModuleData(name = "Moje krowy", description = "Zarządzaj swoimi krowami", image = "/ic_my_cows.png", action = Module.Action.VIEW_COWS))
        moduleDAO.create(ModuleData(name = "Moje buhaje", description = "Zarządzaj swoimi buhajami", image = "/ic_my_bulls.png", action = Module.Action.VIEW_BULLS))
    }

    fun getAllModules() : List<Module> {
        return moduleDAO.getAll()
    }

    fun getAllCows() : List<Cow> {
        return cowDAO.getAll()
    }

    fun getAllBulls() : List<Bull> {
        return bullDAO.getAll()
    }
}
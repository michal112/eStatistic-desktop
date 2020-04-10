package app.estat.desktop.db

import app.estat.desktop.model.Bull
import app.estat.desktop.model.BullData
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

class BullDAO : DAO<BullData, Bull> {
    override fun getAll(): List<Bull> {
        val bulls = mutableListOf<Bull>()
        transaction(DbHelper.db) {
            addLogger(StdOutSqlLogger)
            bulls.addAll(Bull.all().toList())
        }
        return bulls
    }

    override fun create(data: BullData): Bull {
        val bull: Bull by lazy {
            transaction(DbHelper.db) {
                addLogger(StdOutSqlLogger)
                Bull.new {
                    publicId = data.publicId!!
                    name = data.name
                    number = data.number
                }
            }
        }
        return bull
    }

    override fun delete(bull: Bull) {
        transaction(DbHelper.db) {
            addLogger(StdOutSqlLogger)
            bull.delete()
        }
    }
}
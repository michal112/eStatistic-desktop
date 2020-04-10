package app.estat.desktop.db

import app.estat.desktop.model.Cow
import app.estat.desktop.model.CowData
import app.estat.desktop.util.dateTime
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

class CowDAO : DAO<CowData, Cow> {
    override fun getAll(): List<Cow> {
        val cows = mutableListOf<Cow>()
        transaction(DbHelper.db) {
            addLogger(StdOutSqlLogger)
            cows.addAll(Cow.all().toList())
        }
        return cows
    }

    override fun create(data: CowData): Cow {
        val cow: Cow by lazy {
            transaction(DbHelper.db) {
                addLogger(StdOutSqlLogger)
                Cow.new {
                    publicId = data.publicId!!
                    name = data.name
                    number = data.number
                    birthday = data.birthday.dateTime()
                    book = data.book
                }
            }
        }
        return cow
    }

    override fun delete(cow: Cow) {
        transaction(DbHelper.db) {
            addLogger(StdOutSqlLogger)
            cow.delete()
        }
    }
}
package app.estat.desktop.db

import app.estat.desktop.model.Data
import org.jetbrains.exposed.dao.IntEntity

interface DAO<T : Data, E : IntEntity> {
    fun getAll() : List<E>

    fun create(data: T) : E
}


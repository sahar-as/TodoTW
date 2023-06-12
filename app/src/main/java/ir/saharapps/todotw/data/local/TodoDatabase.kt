package ir.saharapps.todotw.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.saharapps.todotw.domain.models.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao
}
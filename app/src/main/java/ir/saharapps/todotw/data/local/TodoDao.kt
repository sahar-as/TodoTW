package ir.saharapps.todotw.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ir.saharapps.todotw.domain.models.Todo

@Dao
interface TodoDao{

    @Query("SELECT * FROM todo_table")
    suspend fun getTodoList(): List<Todo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTodo(todo: Todo)

    @Update
    suspend fun update(todo: Todo)
}
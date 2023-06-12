package ir.saharapps.todotw.data.repository

import ir.saharapps.todotw.data.models.Todo
import ir.saharapps.todotw.domain.interfaces.TodoInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val todoInterface: TodoInterface
) {
    suspend fun getTodoList(): List<Todo>{
        return todoInterface.getTodoList()
    }

    suspend fun addNewTodo(todo: Todo){
        todoInterface.addNewTodo(todo)
    }

    suspend fun updateTodo(todo: Todo){
        todoInterface.updateTodo(todo)
    }
}
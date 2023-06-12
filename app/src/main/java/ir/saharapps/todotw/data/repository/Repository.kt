package ir.saharapps.todotw.data.repository

import ir.saharapps.todotw.data.models.Todo
import ir.saharapps.todotw.domain.interfaces.TodoInterface
import javax.inject.Inject

class Repository @Inject constructor(
    private val todoInterface: TodoInterface
) {
    suspend fun addNewTodo(todo: Todo){
        todoInterface.addNewTodo(todo)
    }

    suspend fun updateTodo(todo: Todo){
        todoInterface.updateTodo(todo)
    }
}
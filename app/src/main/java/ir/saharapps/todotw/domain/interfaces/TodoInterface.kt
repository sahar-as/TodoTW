package ir.saharapps.todotw.domain.interfaces

import ir.saharapps.todotw.data.models.Todo

interface TodoInterface {

    suspend fun getTodoList(): List<Todo>
    suspend fun addNewTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
}
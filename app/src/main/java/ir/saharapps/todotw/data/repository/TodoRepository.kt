package ir.saharapps.todotw.data.repository

import ir.saharapps.todotw.domain.models.Todo

interface TodoRepository {
    suspend fun getTodoList(): List<Todo>
    suspend fun addTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
}
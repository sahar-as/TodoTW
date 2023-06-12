package ir.saharapps.todotw.data.repository

import ir.saharapps.todotw.data.local.TodoDatabase
import ir.saharapps.todotw.domain.models.Todo
import javax.inject.Inject

class TodoRepository @Inject constructor(
    private val dataBseSource: TodoDatabase
) {
    private val todoDao = dataBseSource.todoDao()

    suspend fun getTodoList(): List<Todo>{
        return todoDao.getTodoList()
    }

    suspend fun addTodo(todo: Todo){
        todoDao.addTodo(todo)
    }

    suspend fun updateTodo(todo: Todo){
        todoDao.update(todo)
    }
}
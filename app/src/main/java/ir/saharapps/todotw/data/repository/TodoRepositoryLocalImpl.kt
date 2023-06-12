package ir.saharapps.todotw.data.repository

import ir.saharapps.todotw.data.local.TodoDatabase
import ir.saharapps.todotw.domain.models.Todo
import javax.inject.Inject

class TodoRepositoryLocalImpl @Inject constructor(
    private val databaseSource: TodoDatabase
): TodoRepository {

    private val todoDao = databaseSource.todoDao()

    override suspend fun getTodoList(): List<Todo> {
        return todoDao.getTodoList()
    }

    override suspend fun addTodo(todo: Todo) {
        todoDao.addTodo(todo)
    }

    override suspend fun updateTodo(todo: Todo) {
        todoDao.update(todo)
    }
}
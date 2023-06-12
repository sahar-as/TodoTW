package ir.saharapps.todotw.data.repository

import ir.saharapps.todotw.data.local.TodoDatabase
import ir.saharapps.todotw.data.models.Todo
import ir.saharapps.todotw.domain.interfaces.TodoInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoInterfaceImp @Inject constructor(
    todoDatabase: TodoDatabase
): TodoInterface {

    private val todoDao = todoDatabase.todoDao()

    override suspend fun getTodoList(): List<Todo> {
        return todoDao.getTodoList()
    }

    override suspend fun addNewTodo(todo: Todo) {
        todoDao.insertTodo(todo)
    }

    override suspend fun updateTodo(todo: Todo) {
        todoDao.update(todo)
    }
}
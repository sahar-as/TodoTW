package ir.saharapps.todotw.domain.usecase

import ir.saharapps.todotw.domain.models.Todo
import ir.saharapps.todotw.data.repository.TodoRepository
import javax.inject.Inject

class AddNewTodoUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(todo: Todo){
        todoRepository.addTodo(todo)
    }
}
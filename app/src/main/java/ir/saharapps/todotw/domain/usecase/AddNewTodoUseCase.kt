package ir.saharapps.todotw.domain.usecase

import ir.saharapps.todotw.data.repository.TodoRepositoryLocalImpl
import ir.saharapps.todotw.domain.models.Todo
import javax.inject.Inject

class AddNewTodoUseCase @Inject constructor(
    private val todoRepository: TodoRepositoryLocalImpl
) {
    suspend operator fun invoke(todo: Todo){
        todoRepository.addTodo(todo)
    }
}
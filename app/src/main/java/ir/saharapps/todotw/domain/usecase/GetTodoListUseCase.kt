package ir.saharapps.todotw.domain.usecase

import ir.saharapps.todotw.domain.models.Todo
import ir.saharapps.todotw.data.repository.TodoRepository
import javax.inject.Inject

class GetTodoListUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(): List<Todo>{
        return todoRepository.getTodoList()
    }
}
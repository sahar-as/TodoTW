package ir.saharapps.todotw.domain.usecase

import ir.saharapps.todotw.data.repository.TodoRepositoryLocalImpl
import ir.saharapps.todotw.domain.models.Todo
import javax.inject.Inject

class GetTodoListUseCase @Inject constructor(
    private val todoRepository: TodoRepositoryLocalImpl
) {
    suspend operator fun invoke(): List<Todo>{
        return todoRepository.getTodoList()
    }
}
package ir.saharapps.todotw.domain.usecase

import ir.saharapps.todotw.data.models.Todo
import ir.saharapps.todotw.data.repository.Repository
import javax.inject.Inject

class GetTodoListUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): List<Todo>{
        return repository.getTodoList()
    }
}
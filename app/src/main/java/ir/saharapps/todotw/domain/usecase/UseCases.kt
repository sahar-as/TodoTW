package ir.saharapps.todotw.domain.usecase

data class UseCases(
    val getTodoListUseCase: GetTodoListUseCase,
    val addNewTodoUseCase: AddNewTodoUseCase,
    val updateTodoUseCase: UpdateTodoUseCase

)
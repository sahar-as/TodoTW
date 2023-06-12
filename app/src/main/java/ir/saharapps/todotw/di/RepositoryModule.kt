package ir.saharapps.todotw.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.saharapps.todotw.data.repository.TodoRepository
import ir.saharapps.todotw.domain.usecase.AddNewTodoUseCase
import ir.saharapps.todotw.domain.usecase.GetTodoListUseCase
import ir.saharapps.todotw.domain.usecase.UpdateTodoUseCase
import ir.saharapps.todotw.domain.usecase.UseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUseCase(todoRepository: TodoRepository): UseCases {
        return UseCases(
            getTodoListUseCase = GetTodoListUseCase(todoRepository),
            addNewTodoUseCase = AddNewTodoUseCase(todoRepository),
            updateTodoUseCase = UpdateTodoUseCase(todoRepository)
        )
    }
}
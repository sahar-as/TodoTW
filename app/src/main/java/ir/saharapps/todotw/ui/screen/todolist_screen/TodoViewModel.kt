package ir.saharapps.todotw.ui.screen.todolist_screen

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.saharapps.todotw.data.models.Todo
import ir.saharapps.todotw.domain.usecase.UseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    private val _todoList = MutableStateFlow<List<Todo>>(emptyList())
    val todoList: StateFlow<List<Todo>> = _todoList

    fun getAllTodo(){
        viewModelScope.launch(Dispatchers.IO){
            _todoList.value = useCases.getTodoListUseCase()
        }
    }

    fun addNewTodo(todo: Todo){
        viewModelScope.launch(Dispatchers.IO) {
            useCases.addNewTodoUseCase(todo)
            getAllTodo()
        }
    }
}
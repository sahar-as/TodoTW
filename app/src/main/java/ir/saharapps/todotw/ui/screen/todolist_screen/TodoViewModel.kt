package ir.saharapps.todotw.ui.screen.todolist_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.saharapps.todotw.data.repository.TodoRepositoryLocalImpl
import ir.saharapps.todotw.domain.models.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoRepositoryLocalImpl: TodoRepositoryLocalImpl
): ViewModel() {

    private val _todoList = MutableStateFlow<List<Todo>>(emptyList())
    val todoList: StateFlow<List<Todo>> = _todoList

    private val todoEventChannel = Channel<TodoEvent>()
    val todoEvent = todoEventChannel.receiveAsFlow()

    fun getAllTodo(){
        viewModelScope.launch(Dispatchers.IO){
            _todoList.value = todoRepositoryLocalImpl.getTodoList()
        }
    }

    fun addNewTodo(todoContent: String){
        viewModelScope.launch(Dispatchers.IO) {
            if(todoContent.isNotEmpty()){
                val newTodo = Todo(todoContent, false)
                todoRepositoryLocalImpl.addTodo(newTodo)
                getAllTodo()
            }else{
                todoEventChannel.send(TodoEvent.ShowEmptyErrorMessage)
            }
        }
    }

    sealed class TodoEvent{
        object ShowEmptyErrorMessage: TodoEvent()
    }
}
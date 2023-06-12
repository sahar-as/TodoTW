package ir.saharapps.todotw.ui.screen.todolist_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.saharapps.todotw.data.models.Todo
import ir.saharapps.todotw.databinding.ActivityTodoBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoViewModel: TodoViewModel by viewModels()
        val todoAdapter = TodoAdapter(){ id, isDone ->
            //todo create use case to get todo with id
            //todo update todo with copy new isDone State
        }
        todoViewModel.getAllTodo()

        binding.rvTodoList.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = todoAdapter
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                todoViewModel.todoList.collect{
                    todoAdapter.submitList(it)
                }
            }
        }

        binding.btnAddNewTodo.setOnClickListener{
            val todoContent = binding.edtTodoContent.text.toString()
            if(todoContent.isNotEmpty()){
                val newTodo = Todo(todoContent, false)
                todoViewModel.addNewTodo(newTodo)
            }
        }
    }
}
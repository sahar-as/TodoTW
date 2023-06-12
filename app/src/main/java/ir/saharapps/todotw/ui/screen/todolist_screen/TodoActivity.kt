package ir.saharapps.todotw.ui.screen.todolist_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import ir.saharapps.todotw.data.models.Todo
import ir.saharapps.todotw.databinding.ActivityTodoBinding
import kotlinx.coroutines.flow.collect
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
            //todo update database with copy new isDone State
        }
        todoViewModel.getAllTodo()

        binding.rvTodo.apply {
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

        lifecycleScope.launch {
            todoViewModel.todoEvent.collect{
                when(it){
                    TodoViewModel.TodoEvent.ShowEmptyErrorMessage ->{
                        Toast.makeText(this@TodoActivity, "Write Todo!", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        binding.btnAddTodo.setOnClickListener{
            val todoContent = binding.edtTodoContent.text.toString()
            todoViewModel.addNewTodo(todoContent)
        }
    }

}
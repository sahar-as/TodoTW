package ir.saharapps.todotw.ui.screen.todolist_screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.saharapps.todotw.databinding.ActivityTodoBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoViewModel: TodoViewModel by viewModels()
        val todoAdapter = TodoAdapter()



        binding.rvTodoList.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = todoAdapter
        }


        lifecycleScope.launch {
            todoViewModel.todoList.collect{
                todoAdapter.submitList(it)
            }
        }


    }
}
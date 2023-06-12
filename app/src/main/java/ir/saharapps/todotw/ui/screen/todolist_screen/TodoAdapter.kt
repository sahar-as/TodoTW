package ir.saharapps.todotw.ui.screen.todolist_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.saharapps.todotw.data.models.Todo
import ir.saharapps.todotw.databinding.TodoItemBinding

class TodoAdapter(private val onClick: (id: Int, isDone:Boolean) -> Unit): ListAdapter<Todo, TodoAdapter.TodoViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class TodoViewHolder(private val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(todo: Todo){
            binding.apply {
                txtTodoItem.text = todo.todoContent
                chkDoneStatus.isChecked = todo.isDone

                root.setOnClickListener {
                    onClick(todo.id, !todo.isDone)
                }
            }
        }
    }

    class DiffCallBack: DiffUtil.ItemCallback<Todo>(){
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo) =
            oldItem == newItem
    }

}
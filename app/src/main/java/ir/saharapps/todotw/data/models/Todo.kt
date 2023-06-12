package ir.saharapps.todotw.data.models

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Entity(tableName = "todo_table")
@Parcelize
data class Todo(
    val id: Int = 0,
    val todoContent: String,
    val isDone: Boolean
): Parcelable
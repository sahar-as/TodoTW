package ir.saharapps.todotw.domain.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "todo_table")
@Parcelize
data class Todo(
    val todoContent: String,
    val isDone: Boolean,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
): Parcelable
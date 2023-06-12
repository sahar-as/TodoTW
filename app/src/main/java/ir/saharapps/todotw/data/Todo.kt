package ir.saharapps.todotw.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Todo(
    val id: Int = 0,
    val todoContent: String,
    val isDone: Boolean
): Parcelable
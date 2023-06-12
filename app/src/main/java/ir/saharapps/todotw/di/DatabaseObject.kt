package ir.saharapps.todotw.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.saharapps.todotw.data.local.TodoDatabase
import ir.saharapps.todotw.utils.Constants.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseObject {

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TodoDatabase::class.java, DATABASE_NAME)


}
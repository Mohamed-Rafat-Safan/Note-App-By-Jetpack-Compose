package com.example.data.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.utils.Constant.DATABASE_NAME
import com.example.domain.entities.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        // this annotation make the field immediately visible to other threads
        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            // if the instance is null we are creating a new instance
            // synchronized block will prevent other thread from accessing this instance
            // fallbackToDestructiveMigration() to update the database if version is changed
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    DATABASE_NAME
                ).fallbackToDestructiveMigration().build()


                INSTANCE = instance
                return instance
            }
        }
    }
}
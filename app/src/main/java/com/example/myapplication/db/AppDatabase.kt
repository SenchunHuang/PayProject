package com.example.myapplication.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.MyApplication
import com.example.myapplication.model.ProjectEntity

/*
* room的基础类
*/
@Database(entities = [ProjectEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun payProjectDao(): PayProjectDao

    companion object {
        @Volatile
        private var instantce: AppDatabase? = null
        private const val DB_NAME = "room.db"

        @Synchronized
        fun getInstance(): AppDatabase {
            if (instantce == null) {
                instantce = createInstance()
            }
            return instantce!!
        }

        private fun createInstance(): AppDatabase {
            return Room.databaseBuilder(MyApplication.getApp(), AppDatabase::class.java, DB_NAME)
                .allowMainThreadQueries()
                .build()
        }
    }



}
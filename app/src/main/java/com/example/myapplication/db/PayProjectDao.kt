package com.example.myapplication.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.ProjectEntity
/*
* 数据库实体类
*/
@Dao
interface PayProjectDao {
    @Query("SELECT * FROM ProjectEntity")
    fun getAll(): List<ProjectEntity>

    @Insert
    fun insert(payProject: ProjectEntity)

    @Delete
    fun delete(payProject: ProjectEntity)
}
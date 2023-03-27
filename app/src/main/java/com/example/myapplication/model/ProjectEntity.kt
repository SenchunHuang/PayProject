package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ProjectEntity(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                         @ColumnInfo(name = "project") val project: String?,
                         @ColumnInfo(name = "feeCny") val feeCny: Double?,
                         @ColumnInfo(name = "feeUsd") val feeUsd: Double?,
                         @ColumnInfo(name = "date") val date:String)
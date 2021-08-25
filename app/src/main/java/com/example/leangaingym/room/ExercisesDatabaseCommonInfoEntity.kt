package com.example.leangaingym.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises_data_base_table_info")
class ExercisesDatabaseCommonInfoEntity (

    @PrimaryKey
    @ColumnInfo
    val id: Int,

    @ColumnInfo
    val exerciseName: String,

    @ColumnInfo
    val description: String,

    @ColumnInfo
    val date: String

)
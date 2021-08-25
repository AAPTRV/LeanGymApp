package com.example.leangaingym.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "templates_data_base_info")
class TemplatesDatabaseCommonInfoEntity(

    @PrimaryKey
    @ColumnInfo
    val id: Int,

    @ColumnInfo
    val templateName: String,

    @ColumnInfo
    val description: String,

    @ColumnInfo
    val date: String

)
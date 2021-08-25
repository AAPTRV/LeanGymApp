package com.example.leangaingym.room

import androidx.room.*

@Dao
interface TemplatesCommonInfoDAO {

    @Query("SELECT * FROM templates_data_base_info")
    fun getAllTemplatesInfo(): List<TemplatesDatabaseCommonInfoEntity>

    @Query("SELECT * FROM exercises_data_base_table_info WHERE id = :id")
    fun getTemplateById(id: Int): TemplatesDatabaseCommonInfoEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add(entity: TemplatesDatabaseCommonInfoEntity)

    @Delete
    fun delete(entity: TemplatesDatabaseCommonInfoEntity)

}
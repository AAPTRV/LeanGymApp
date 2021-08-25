package com.example.leangaingym.room

import androidx.room.*

@Dao
interface ExercisesCommonInfoDAO {

    @Query("SELECT * FROM exercises_data_base_table_info")
    fun getAllExercisesInfo(): List<ExercisesDatabaseCommonInfoEntity>

    @Query("SELECT * FROM exercises_data_base_table_info WHERE id = :id")
    fun getExerciseById(id: Int): ExercisesDatabaseCommonInfoEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add(entity: ExercisesDatabaseCommonInfoEntity)

    @Delete
    fun delete(entity: ExercisesDatabaseCommonInfoEntity)

}
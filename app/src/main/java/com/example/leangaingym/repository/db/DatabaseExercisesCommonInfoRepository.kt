package com.example.leangaingym.repository.db

import com.example.leangaingym.room.ExercisesDatabaseCommonInfoEntity

interface DatabaseExercisesCommonInfoRepository {

    fun getAllExercisesInfo(): List<ExercisesDatabaseCommonInfoEntity>
    fun getExerciseById(id: Int): ExercisesDatabaseCommonInfoEntity
    fun add(entity: ExercisesDatabaseCommonInfoEntity)
    fun delete(entity: ExercisesDatabaseCommonInfoEntity)

}
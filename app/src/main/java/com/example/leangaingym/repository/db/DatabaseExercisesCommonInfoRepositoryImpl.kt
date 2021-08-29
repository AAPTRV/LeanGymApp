package com.example.leangaingym.repository.db

import com.example.leangaingym.app.ExercisesApp
import com.example.leangaingym.room.DBInfo
import com.example.leangaingym.room.ExercisesDatabaseCommonInfoEntity

class DatabaseExercisesCommonInfoRepositoryImpl(private val db: DBInfo = ExercisesApp.mDatabase): DatabaseExercisesCommonInfoRepository {

    override fun getAllExercisesInfo(): List<ExercisesDatabaseCommonInfoEntity> {
        return db.getExercisesListInfoDAO().getAllExercisesInfo()
    }

    override fun getExerciseById(id: Int): ExercisesDatabaseCommonInfoEntity {
        return db.getExercisesListInfoDAO().getExerciseById(id)
    }

    override fun add(entity: ExercisesDatabaseCommonInfoEntity) {
        return db.getExercisesListInfoDAO().add(entity)
    }

    override fun delete(entity: ExercisesDatabaseCommonInfoEntity) {
        return db.getExercisesListInfoDAO().delete(entity)
    }

}
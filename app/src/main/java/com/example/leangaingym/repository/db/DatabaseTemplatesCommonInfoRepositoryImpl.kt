package com.example.leangaingym.repository.db

import com.example.leangaingym.app.ExercisesApp
import com.example.leangaingym.room.DBInfo
import com.example.leangaingym.room.TemplatesDatabaseCommonInfoEntity

class DatabaseTemplatesCommonInfoRepositoryImpl(private val db: DBInfo = ExercisesApp.mDatabase) :
    DatabaseTemplatesCommonInfoRepository {

    override fun getAllTemplatesInfo(): List<TemplatesDatabaseCommonInfoEntity> {
        return db.getTemplatesListInfoDAO().getAllTemplatesInfo()
    }

    override fun add(entity: TemplatesDatabaseCommonInfoEntity) {
        return db.getTemplatesListInfoDAO().add(entity)
    }

    override fun delete(entity: TemplatesDatabaseCommonInfoEntity) {
        return db.getTemplatesListInfoDAO().delete(entity)
    }

    override fun getTemplateById(id: Int): TemplatesDatabaseCommonInfoEntity {
        return db.getTemplatesListInfoDAO().getTemplateById(id)
    }

}
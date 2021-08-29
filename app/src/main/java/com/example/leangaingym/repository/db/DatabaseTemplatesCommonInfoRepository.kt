package com.example.leangaingym.repository.db

import com.example.leangaingym.room.TemplatesDatabaseCommonInfoEntity

interface DatabaseTemplatesCommonInfoRepository {

    fun getAllTemplatesInfo(): List<TemplatesDatabaseCommonInfoEntity>
    fun add(entity: TemplatesDatabaseCommonInfoEntity)
    fun delete(entity: TemplatesDatabaseCommonInfoEntity)

}
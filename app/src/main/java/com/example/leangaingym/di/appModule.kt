package com.example.leangaingym.di

import com.example.leangaingym.repository.db.DatabaseExercisesCommonInfoRepository
import com.example.leangaingym.repository.db.DatabaseExercisesCommonInfoRepositoryImpl
import com.example.leangaingym.repository.db.DatabaseTemplatesCommonInfoRepository
import com.example.leangaingym.repository.db.DatabaseTemplatesCommonInfoRepositoryImpl
import com.example.leangaingym.room.DBInfo
import org.koin.dsl.module

val appModule = module {

    //Model level
    single { DBInfo.init(get()) }

    //Data level
    single <DatabaseExercisesCommonInfoRepository>{ DatabaseExercisesCommonInfoRepositoryImpl(get())}
    single <DatabaseTemplatesCommonInfoRepository>{ DatabaseTemplatesCommonInfoRepositoryImpl(get())}

}
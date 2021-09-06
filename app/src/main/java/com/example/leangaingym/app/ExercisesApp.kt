package com.example.leangaingym.app

import android.app.Application
import com.example.leangaingym.di.appModule
import com.example.leangaingym.di.editTemplateModule
import com.example.leangaingym.di.exerciseTuningModule
import com.example.leangaingym.di.templateInfoModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ExercisesApp: Application() {

//    companion object{
//        lateinit var mDatabase: DBInfo
//    }

    override fun onCreate() {
        super.onCreate()
//        mDatabase = this.let { DBInfo.init(it) }
        startKoin {
            // Koin Android logger
            androidLogger()
            // inject Android context
            androidContext(this@ExercisesApp)
            // use modules
            modules(appModule, editTemplateModule, exerciseTuningModule, templateInfoModule)
        }
    }
}
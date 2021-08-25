package com.example.leangaingym.app

import android.app.Application
import com.example.leangaingym.room.DBInfo

class ExercisesApp: Application() {

    companion object{
        lateinit var mDatabase: DBInfo
    }

    override fun onCreate() {
        super.onCreate()
        mDatabase = this.let { DBInfo.init(it) }
    }
}
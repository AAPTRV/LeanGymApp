package com.example.leangaingym.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.leangaingym.R
import com.example.leangaingym.room.DBInfo
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
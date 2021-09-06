package com.example.leangaingym.di

import androidx.lifecycle.SavedStateHandle
import com.example.leangaingym.screens.exerciseTuning.ExerciseTuningFragment
import com.example.leangaingym.screens.exerciseTuning.ExerciseTuningViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val exerciseTuningModule = module {

    scope<ExerciseTuningFragment> {
        viewModel { (handle: SavedStateHandle) ->
            ExerciseTuningViewModel(handle, get(), get())
        }
    }
}
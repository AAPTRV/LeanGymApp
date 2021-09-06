package com.example.leangaingym.di

import androidx.lifecycle.SavedStateHandle
import com.example.leangaingym.screens.exerciseTuning.ExerciseTuningFragment
import com.example.leangaingym.screens.exerciseTuning.ExerciseTuningViewModel
import com.example.leangaingym.screens.templateInfoFragment.TemplateInfoFragment
import com.example.leangaingym.screens.templateInfoFragment.TemplateInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val templateInfoModule = module {

    scope<TemplateInfoFragment> {
        viewModel { (handle: SavedStateHandle) ->
            TemplateInfoViewModel(handle, get(), get())
        }
    }
}
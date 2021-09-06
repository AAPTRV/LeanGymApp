package com.example.leangaingym.di

import androidx.lifecycle.SavedStateHandle
import com.example.leangaingym.screens.editTemplateFragment.EditTemplateFragment
import com.example.leangaingym.screens.editTemplateFragment.EditTemplateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val editTemplateModule = module {

    scope<EditTemplateFragment> {
        viewModel { (handle: SavedStateHandle) ->
            EditTemplateViewModel(handle, get(), get())
        }
    }
}
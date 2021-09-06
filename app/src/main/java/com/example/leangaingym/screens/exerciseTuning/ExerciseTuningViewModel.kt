package com.example.leangaingym.screens.exerciseTuning

import androidx.lifecycle.SavedStateHandle
import com.example.leangaingym.base.mvvm.BaseViewModel
import com.example.leangaingym.dto.TemplateDescriptionDto
import com.example.leangaingym.ext.dbAndDtoTransformer.convertToDto
import com.example.leangaingym.repository.db.DatabaseExercisesCommonInfoRepository
import com.example.leangaingym.repository.db.DatabaseTemplatesCommonInfoRepository
import com.example.leangaingym.room.TemplatesDatabaseCommonInfoEntity

class ExerciseTuningViewModel(
    savedStateHandle: SavedStateHandle,
    private val mDatabaseExercisesCommonInfoRepository: DatabaseExercisesCommonInfoRepository,
    private val mDatabaseTemplatesCommonInfoRepository: DatabaseTemplatesCommonInfoRepository
) : BaseViewModel(savedStateHandle) {

    fun addTemplateToDatabase(template: TemplatesDatabaseCommonInfoEntity){
        mDatabaseTemplatesCommonInfoRepository.add(template)
    }

    fun getAllTemplatesFromDatabase(): List<TemplateDescriptionDto>{
        return mDatabaseTemplatesCommonInfoRepository.getAllTemplatesInfo().convertToDto()
    }

    fun getAllTemplatesFromDataBaseCount(): Int{
        return mDatabaseTemplatesCommonInfoRepository.getAllTemplatesInfo().size
    }

}
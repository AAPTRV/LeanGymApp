package com.example.leangaingym.screens.templateInfoFragment

import androidx.lifecycle.SavedStateHandle
import com.example.leangaingym.base.mvvm.BaseViewModel
import com.example.leangaingym.dto.TemplateDescriptionDto
import com.example.leangaingym.ext.dbAndDtoTransformer.convertToDto
import com.example.leangaingym.repository.db.DatabaseExercisesCommonInfoRepository
import com.example.leangaingym.repository.db.DatabaseTemplatesCommonInfoRepository
import com.example.leangaingym.room.TemplatesDatabaseCommonInfoEntity

class TemplateInfoViewModel (
    savedStateHandle: SavedStateHandle,
    private val mDatabaseExercisesCommonInfoRepository: DatabaseExercisesCommonInfoRepository,
    private val mDatabaseTemplatesCommonInfoRepository: DatabaseTemplatesCommonInfoRepository
) : BaseViewModel(savedStateHandle) {

//    fun addTemplateToDatabase(template: TemplatesDatabaseCommonInfoEntity){
//        mDatabaseTemplatesCommonInfoRepository.add(template)
//    }

    fun getTemplateFromDatabase(templateId: Int) : TemplateDescriptionDto{
        return mDatabaseTemplatesCommonInfoRepository.getTemplateById(templateId).convertToDto()
    }
}
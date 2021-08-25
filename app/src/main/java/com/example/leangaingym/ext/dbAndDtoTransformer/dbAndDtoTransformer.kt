package com.example.leangaingym.ext.dbAndDtoTransformer

import com.example.leangaingym.dto.TemplateDescriptionDto
import com.example.leangaingym.room.TemplatesDatabaseCommonInfoEntity

fun TemplateDescriptionDto.convertToEntity(): TemplatesDatabaseCommonInfoEntity{
    return TemplatesDatabaseCommonInfoEntity(
        id = this.mId,
        templateName = this.mTemplateName,
        description = this.mDescription,
        date = this.mDate
    )
}

fun List<TemplateDescriptionDto>.convertToEntity(): List<TemplatesDatabaseCommonInfoEntity>{
    val result = mutableListOf<TemplatesDatabaseCommonInfoEntity>()
    for(dto in this){
        result.add(dto.convertToEntity())
    }
    return result
}

fun TemplatesDatabaseCommonInfoEntity.convertToDto():TemplateDescriptionDto{
    return TemplateDescriptionDto(
        mId = this.id,
        mTemplateName = this.templateName,
        mDescription = this.description,
        mDate = this.date
    )
}

fun List<TemplatesDatabaseCommonInfoEntity>.convertToDto(): List<TemplateDescriptionDto>{
    val result = mutableListOf<TemplateDescriptionDto>()
    for(entity in this){
        result.add(entity.convertToDto())
    }
    return result
}
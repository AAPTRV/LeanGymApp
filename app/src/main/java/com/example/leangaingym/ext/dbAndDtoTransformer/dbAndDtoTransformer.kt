package com.example.leangaingym.ext.dbAndDtoTransformer

import com.example.leangaingym.dto.TemplateDescriptionDto
import com.example.leangaingym.dto.TemplateExerciseUnitDto
import com.example.leangaingym.room.TemplatesDatabaseCommonInfoEntity
import java.lang.StringBuilder

fun TemplateDescriptionDto.convertToEntity(): TemplatesDatabaseCommonInfoEntity{
    return TemplatesDatabaseCommonInfoEntity(
        id = this.mId,
        templateName = this.mTemplateName,
        description = this.mDescription,
        date = this.mDate,
        exercises = this.mExercises.convertToEntityFieldString()
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
        mDate = this.date,
        mExercises = this.exercises.convertToTemplateUnitDtoList()
    )
}

fun List<TemplatesDatabaseCommonInfoEntity>.convertToDto(): List<TemplateDescriptionDto>{
    val result = mutableListOf<TemplateDescriptionDto>()
    for(entity in this){
        result.add(entity.convertToDto())
    }
    return result
}

fun String.convertToTemplateUnitDtoList(): List<TemplateExerciseUnitDto>{
    val result = mutableListOf<TemplateExerciseUnitDto>()
    val unitsList = mutableListOf<String>()
    unitsList.addAll(this.split("//"))
    for(unit in unitsList){
        val unitArray = mutableListOf<String>()
        unitArray.addAll(unit.split(","))
        println("unitArrayList: $unitArray")
        unitArray.forEach { it.replace(",", "") }
        result.add(TemplateExerciseUnitDto(
            mExerciseName = unitArray[0],
            mNumberOfApproaches = unitArray[1].trim().toInt(),
            mNumberOfRepetitions = unitArray[2].trim().toInt()
        ))
    }
    return result
}

fun List<TemplateExerciseUnitDto>.convertToEntityFieldString(): String{
    val sb = StringBuilder()
    this.forEachIndexed {index, templateUnit ->
        sb.append("${templateUnit.mExerciseName},")
        sb.append("${templateUnit.mNumberOfApproaches},")
        if(index < this.size - 1){
            sb.append("${templateUnit.mNumberOfRepetitions}//")
        } else {sb.append("${templateUnit.mNumberOfRepetitions}")}
    }
    return sb.toString()
}
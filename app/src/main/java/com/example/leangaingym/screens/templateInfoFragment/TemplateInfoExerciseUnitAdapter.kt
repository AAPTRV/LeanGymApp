package com.example.leangaingym.screens.templateInfoFragment

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.leangaingym.R
import com.example.leangaingym.base.adapter.BaseAdapter
import com.example.leangaingym.dto.TemplateDescriptionDto
import com.example.leangaingym.dto.TemplateExerciseUnitDto

class TemplateInfoExerciseUnitAdapter: BaseAdapter<TemplateDescriptionDto>() {

    inner class ExerciseUnitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUnitName: AppCompatTextView = itemView.findViewById(R.id.unitName)
        val tvNumberOfApproaches: AppCompatTextView =
            itemView.findViewById(R.id.unitApproaches)
        val tvNumberOfRepetitions: AppCompatTextView = itemView.findViewById(R.id.unitScope)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_training_unit, parent, false)
        return ExerciseUnitViewHolder(v)
    }

    override fun getItemCount(): Int = mDataListInAdapter[0].mExercises.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ExerciseUnitViewHolder){
            Log.e("HZ", "EXERCISES SIZE = ${mDataListInAdapter[0].mExercises.size}")
            val exerciseUnit = mDataListInAdapter[0].mExercises[position]
            holder.tvUnitName.text = exerciseUnit.mExerciseName
            holder.tvNumberOfApproaches.text = exerciseUnit.mNumberOfApproaches.toString()
            holder.tvNumberOfRepetitions.text = exerciseUnit.mNumberOfRepetitions.toString()
        }
    }

    fun repopulateAdapterData(templateDescriptionDto: TemplateDescriptionDto){
        mDataListInAdapter.clear()
        mDataListInAdapter.add(templateDescriptionDto)
        notifyDataSetChanged()
    }
}
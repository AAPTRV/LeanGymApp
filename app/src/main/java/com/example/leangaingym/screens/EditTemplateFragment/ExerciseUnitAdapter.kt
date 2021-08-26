package com.example.leangaingym.screens.EditTemplateFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.leangaingym.R
import com.example.leangaingym.base.adapter.BaseAdapter
import com.example.leangaingym.dto.TemplateExerciseUnitDto

class ExerciseUnitAdapter : BaseAdapter<TemplateExerciseUnitDto>() {

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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ExerciseUnitViewHolder){
            val exerciseUnit = mDataListInAdapter[position]
            holder.tvUnitName.text = exerciseUnit.mExerciseName
            holder.tvNumberOfApproaches.text = exerciseUnit.mNumberOfApproaches.toString()
            holder.tvNumberOfRepetitions.text = exerciseUnit.mNumberOfRepetitions.toString()
        }
    }

    fun repopulateAdapterData(exercisesList: List<TemplateExerciseUnitDto>){
        mDataListInAdapter.clear()
        mDataListInAdapter.addAll(exercisesList)
        notifyDataSetChanged()
    }

}
package com.example.leangaingym.screens.exercisesListFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.leangaingym.R
import com.example.leangaingym.base.adapter.BaseAdapter
import com.example.leangaingym.dto.ExerciseDescriptionDto

class ExercisesAdapter : BaseAdapter<ExerciseDescriptionDto>() {

    inner class ExercisesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvExerciseName: AppCompatTextView = itemView.findViewById(R.id.exerciseName)
        val tvDescription: AppCompatTextView = itemView.findViewById(R.id.exerciseCommonDescription)
        val tvDate: AppCompatTextView = itemView.findViewById(R.id.exerciseName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_exercise_layout, parent, false)
        return ExercisesViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ExercisesViewHolder){
            val exercise = mDataListInAdapter[position]
            holder.tvExerciseName.text = exercise.mExerciseName
            holder.tvDescription.text = exercise.mDescription
            holder.tvDate.text = exercise.mDate
        }
    }

}
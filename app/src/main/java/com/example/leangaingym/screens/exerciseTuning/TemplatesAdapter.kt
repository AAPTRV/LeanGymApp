package com.example.leangaingym.screens.exerciseTuning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.leangaingym.R
import com.example.leangaingym.base.adapter.BaseAdapter
import com.example.leangaingym.dto.TemplateDescriptionDto

class TemplatesAdapter: BaseAdapter<TemplateDescriptionDto>() {

    inner class TemplatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTemplateName: AppCompatTextView = itemView.findViewById(R.id.templateName)
        val tvDescription: AppCompatTextView = itemView.findViewById(R.id.templateCommonDescription)
        val tvDate: AppCompatTextView = itemView.findViewById(R.id.templateDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_template_layout, parent, false)
        return TemplatesViewHolder(v)
    }

    override fun addListOfItems(list: MutableList<TemplateDescriptionDto>){
        mDataListInAdapter.clear()
        mDataListInAdapter.addAll(list.sortedByDescending { it.mId })
        notifyDataSetChanged()
    }
    

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is TemplatesViewHolder){
            val template = mDataListInAdapter[position]
            holder.tvTemplateName.text = template.mTemplateName
            holder.tvDescription.text = template.mDescription
            holder.tvDate.text = template.mDate
            holder.itemView.setOnClickListener { mOnItemClickListener?.invoke(mDataListInAdapter[position]) }
        }
    }
}
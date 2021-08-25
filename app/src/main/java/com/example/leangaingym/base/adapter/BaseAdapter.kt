package com.example.leangaingym.base.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<ItemType>: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val mDataListInAdapter: MutableList<ItemType> = mutableListOf()

    protected var mOnItemClickListener: ((ItemType) -> Unit?)? = null

    interface OnItemClickListener<ItemType>{
        fun onClick(item: ItemType)
    }

    fun setItemClick(clickListener: (ItemType) -> Unit){
        mOnItemClickListener = clickListener
    }

    open fun addListOfItems(list: MutableList<ItemType>){
        mDataListInAdapter.addAll(list)
        notifyDataSetChanged()
    }

    open fun addItem(item: ItemType){
        mDataListInAdapter.add(item)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = mDataListInAdapter.size

}
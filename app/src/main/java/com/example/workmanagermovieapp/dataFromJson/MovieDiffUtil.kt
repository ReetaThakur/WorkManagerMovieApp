package com.example.workmanagermovieapp.dataFromJson

import androidx.recyclerview.widget.DiffUtil

class MovieDiffUtil(val oldMovieList:List<Result>,
val newMovieList:List<Result>):DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldMovieList.size
    }

    override fun getNewListSize(): Int {
        return newMovieList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMovieList[oldItemPosition].id==newMovieList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldMovieList[oldItemPosition]==newMovieList[newItemPosition]
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}
package com.example.workmanagermovieapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.workmanagermovieapp.R
import com.example.workmanagermovieapp.dataFromJson.MovieDiffUtil
import com.example.workmanagermovieapp.dataFromJson.ResponseDTO
import com.example.workmanagermovieapp.dataFromJson.Result

class CharacterAdapter: PagingDataAdapter<Result, CharacterAdapter.MovieViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Result>() {

            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem:Result): Boolean {
                return oldItem.equals(newItem)
            }

        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val result=getItem(position)
        result.let {
            if (it != null) {
                holder.setData(it)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout,parent,false)
        return MovieViewHolder(view)
    }


    class MovieViewHolder(view:View):RecyclerView.ViewHolder(view){
        val movieName:TextView=view.findViewById(R.id.tvMovieName)
        val movieLanguage:TextView=view.findViewById(R.id.tvMovieLanguage)
        val moviePoster:ImageView=view.findViewById(R.id.moviepost)
        val releaseData:TextView=view.findViewById(R.id.tvMovieReleasedData)
        val popularity:TextView=view.findViewById(R.id.tvMoviePopularity)
        val review:TextView=view.findViewById(R.id.tvMoviePverView)
        val id:TextView=view.findViewById(R.id.tvMovieId)

        fun setData(model:Result){
            var pathImage="https://image.tmdb.org/t/p/w500"
            Glide.with(moviePoster).load(pathImage+model.poster_path).into(moviePoster)
            movieName.text="Movie Name - ${model.title}"
            movieLanguage.text="Language - ${model.original_language}"
            releaseData.text="Released Date - ${model.release_date}"
            popularity.text="Pupularity - ${model.popularity.toString()}"
            review.text="OverView - ${model.overview}"
            id.text="Moive Id - ${model.id}"

        }

    }
}
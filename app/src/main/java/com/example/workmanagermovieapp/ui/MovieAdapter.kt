package com.example.workmanagermovieapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.DifferCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.workmanagermovieapp.R
import com.example.workmanagermovieapp.dataFromJson.MovieDiffUtil
import com.example.workmanagermovieapp.dataFromJson.ResponseDTO
import com.example.workmanagermovieapp.dataFromJson.Result

class MovieAdapter(val context: Context) :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    private val movieList:ArrayList<Result> = ArrayList<Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.movie_item_layout,parent,false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val list=movieList[position]
        holder.setData(list)
    }

    override fun getItemCount(): Int {
       return movieList.size
    }
    fun updateData(newMovieList:List<Result>){
        val diffUtil=MovieDiffUtil(newMovieList,movieList)
        val diffResult=DiffUtil.calculateDiff(diffUtil)
        movieList.clear()
        movieList.addAll(newMovieList)
        diffResult.dispatchUpdatesTo(this)

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
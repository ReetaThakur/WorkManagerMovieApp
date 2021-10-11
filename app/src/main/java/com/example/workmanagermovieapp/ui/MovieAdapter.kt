package com.example.workmanagermovieapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.workmanagermovieapp.R
import com.example.workmanagermovieapp.dataFromJson.ResponseDTO
import com.example.workmanagermovieapp.dataFromJson.Result

class MovieAdapter(val context: Context,val movieList:List<Result>) :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

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
    class MovieViewHolder(view:View):RecyclerView.ViewHolder(view){
        val movieName:TextView=view.findViewById(R.id.tvMovieName)
        val movieLanguage:TextView=view.findViewById(R.id.tvMovieLanguage)
        val moviePoster:ImageView=view.findViewById(R.id.moviepost)

        fun setData(model:Result){
            var pathImage="https://image.tmdb.org/t/p/w500"
            Glide.with(moviePoster).load(pathImage+model.poster_path).into(moviePoster)
            movieName.text=model.title
            movieLanguage.text=model.original_language
        }

    }
}
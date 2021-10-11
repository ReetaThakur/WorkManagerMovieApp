package com.example.workmanagermovieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workmanagermovieapp.R
import com.example.workmanagermovieapp.dataFromJson.APICalling
import com.example.workmanagermovieapp.dataFromJson.Network
import com.example.workmanagermovieapp.dataFromJson.ResponseDTO
import com.example.workmanagermovieapp.dataFromJson.Result
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var movieList:List<Result>
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var viewModel:MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.callApi()
       viewModel.liveData.observe(this,{
           it.let {
               when(it){
                   is MainUIModel.onSuccess->{
                       movieList=it.responseDTO.results
                       movieAdapter= MovieAdapter(this@MainActivity,movieList)
                       var linearLayoutManager=LinearLayoutManager(this@MainActivity)
                       recyclerView.layoutManager=linearLayoutManager
                       recyclerView.adapter=movieAdapter
                   }
                   is MainUIModel.onFailure->{
                       Toast.makeText(this@MainActivity,it.error,Toast.LENGTH_SHORT).show()
                   }
               }
           }
       })
    }

  /*  private fun fetchData() {
        val apiCalling:APICalling
         apiCalling =Network.getRetrofit().create(APICalling::class.java)
        var ree:Call<ResponseDTO> = apiCalling.getInstance(Network.API_KEY)
        ree.enqueue(object :Callback<ResponseDTO>{
            override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                movieList=response.body()!!.results
                movieAdapter= MovieAdapter(this@MainActivity,movieList)
                var linearLayoutManager=LinearLayoutManager(this@MainActivity)
                recyclerView.layoutManager=linearLayoutManager
                recyclerView.adapter=movieAdapter

            }

            override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }*/
}
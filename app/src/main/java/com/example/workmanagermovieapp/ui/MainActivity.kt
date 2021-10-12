package com.example.workmanagermovieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workmanagermovieapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        setAdapter()
        viewModel.searchCharacter().observe(this,{
            it?.let {
                CoroutineScope(Dispatchers.Main).launch {
                    movieAdapter.submitData(it)
                }
            }
        })

    }

    private fun setAdapter() {
        movieAdapter = CharacterAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            this.adapter = movieAdapter
        }
    }
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

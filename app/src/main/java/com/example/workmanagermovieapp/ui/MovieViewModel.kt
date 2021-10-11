package com.example.workmanagermovieapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workmanagermovieapp.dataFromJson.ResponseDTO
import com.example.workmanagermovieapp.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel():ViewModel() {
    private val repo=Repository()
    private val mutableLiveData=MutableLiveData<MainUIModel>()
    val liveData:LiveData<MainUIModel> = mutableLiveData

    fun callApi(){
        CoroutineScope(Dispatchers.IO).launch {
          val responseDTO:ResponseDTO=repo.getCount()
           if (responseDTO.results!=null){
               mutableLiveData.postValue(MainUIModel.onSuccess(responseDTO))
           }else{
               mutableLiveData.postValue(MainUIModel.onFailure("Error Write Code Again"))
           }
        }
    }

}
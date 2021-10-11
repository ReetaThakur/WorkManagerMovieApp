package com.example.workmanagermovieapp.ui

import com.example.workmanagermovieapp.dataFromJson.ResponseDTO

sealed class MainUIModel {
    data class onSuccess(val responseDTO: ResponseDTO):MainUIModel()
    data class onFailure(val error:String):MainUIModel()

}
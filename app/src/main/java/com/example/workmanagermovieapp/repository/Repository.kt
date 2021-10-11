package com.example.workmanagermovieapp.repository

import com.example.workmanagermovieapp.dataFromJson.Network
import com.example.workmanagermovieapp.dataFromJson.ResponseDTO

class Repository {
   suspend fun getCount():ResponseDTO{
       return Network.getApiService().getInstance(Network.API_KEY)
    }
}
package com.example.workmanagermovieapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.workmanagermovieapp.dataFromJson.Network
import com.example.workmanagermovieapp.dataFromJson.ResponseDTO
import com.example.workmanagermovieapp.pagingClasses.CharcterPagingSource

class Repository {
    fun getPageList()= Pager(config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { CharcterPagingSource() }).liveData
}
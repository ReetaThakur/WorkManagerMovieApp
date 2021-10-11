package com.example.workmanagermovieapp.dataFromJson

data class ResponseDTO(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
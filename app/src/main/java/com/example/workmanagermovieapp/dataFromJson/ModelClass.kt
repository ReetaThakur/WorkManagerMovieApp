package com.example.workmanagermovieapp.dataFromJson

data class ModelClass(val movieName:String,
val language:String,
val releasedDate:String,
val popularity:Double,
val overView:String,
val id:Int) {
    override fun equals(other: Any?): Boolean {
        if (javaClass!=other?.javaClass) return false
        val modelClass=other as ModelClass
        if (id!=modelClass.id) return false
        if (movieName!=modelClass.movieName) return false
        if (language!=modelClass.language) return false
        if (releasedDate!=modelClass.releasedDate) return false
        if (popularity!=modelClass.popularity) return false
        if (overView!=modelClass.overView) return false
        return true
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
package com.dsm.myapplication.interfaces

import com.dsm.myapplication.model.DogData
import retrofit2.http.GET

interface DogAPI {
    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): DogData
}
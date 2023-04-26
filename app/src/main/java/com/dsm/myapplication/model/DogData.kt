package com.dsm.myapplication.model

import com.dsm.myapplication.interfaces.DogAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class DogData(val message: String){
    companion object{
        suspend fun fetchRandomDogImage(): String {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val dogApi = retrofit.create(DogAPI::class.java)

            val response = withContext(Dispatchers.IO) { dogApi.getRandomDogImage() }
            return response.message
        }
    }
}
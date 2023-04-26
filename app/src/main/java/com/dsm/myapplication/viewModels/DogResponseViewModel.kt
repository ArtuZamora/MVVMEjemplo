package com.dsm.myapplication.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.dsm.myapplication.model.DogData
import kotlinx.coroutines.launch

class DogResponseViewModel(application: Application) : AndroidViewModel(application) {
    val dogData = MutableLiveData<DogData>()

    fun randomImage(){
        viewModelScope.launch {
            val currentImage = DogData.fetchRandomDogImage()
            dogData.postValue(DogData(currentImage))
        }
    }
}
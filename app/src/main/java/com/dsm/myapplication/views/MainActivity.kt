package com.dsm.myapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.dsm.myapplication.databinding.ActivityMainBinding
import com.dsm.myapplication.model.DogData
import com.dsm.myapplication.viewModels.DogResponseViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dogResponseViewModel: DogResponseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dogResponseViewModel.dogData.observe(this, Observer { dogData: DogData ->
            Picasso.get().load(dogData.message).into(binding.dogImage)
        })

        dogResponseViewModel.randomImage()
        binding.viewContainer.setOnClickListener {
            dogResponseViewModel.randomImage()
        }
    }
}
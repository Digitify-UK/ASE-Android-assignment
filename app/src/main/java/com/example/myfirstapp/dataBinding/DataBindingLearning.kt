package com.example.myfirstapp.dataBinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myfirstapp.R
import com.example.myfirstapp.databinding.ActivityDataBindingLearningBinding
import kotlin.random.Random

class DataBindingLearning : AppCompatActivity() {

    private lateinit var bindingLearning: ActivityDataBindingLearningBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val randomNumber: RandomNumber = RandomNumber(12)
        bindingLearning =
            DataBindingUtil.setContentView(this, R.layout.activity_data_binding_learning)
        bindingLearning.bindingBtn.setOnClickListener {
            randomNumber.randomNumber = Random.nextInt(12, 34)
            bindingLearning.num = randomNumber
        }
    }
}
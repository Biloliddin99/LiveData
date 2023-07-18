package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.adapters.MyRvAdapter
import com.example.livedata.databinding.ActivityMainBinding
import com.example.livedata.viewModel.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myRvAdapter: MyRvAdapter
    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        MyViewModel()
        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        myViewModel.getAllData().observe(this) {
            myRvAdapter = MyRvAdapter(it)
            binding.myRv.adapter = myRvAdapter
        }

    }
}
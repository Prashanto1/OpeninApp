package com.example.openinapp


import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import com.example.openinapp.databinding.ActivityMainBinding
import com.example.openinapp.ui.MainViewModel
import com.example.openinapp.utils.ApiState

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    getDetails()

    }

    private fun getDetails(){
        val tvName =findViewById<TextView>(R.id.tvName)
        lifecycleScope.launchWhenStarted {


            viewModel.data.collect {
                when (it) {
                    is ApiState.Loading -> {
                        // Handle loading state if needed
                    }
                    is ApiState.Success -> {
                        binding.apply {
                            tvName.isVisible = true // id of name
                            tvName.text = it.data.Name
                        }
                    }
                    is ApiState.Failure -> {
                        // Handle error state if needed
                    }
                }
            }
        }

    }
    }


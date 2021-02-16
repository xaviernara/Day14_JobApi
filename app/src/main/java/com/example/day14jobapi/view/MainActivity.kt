package com.example.day14jobapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.day14jobapi.R
import com.example.day14jobapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(binding.root)
        }

        loadFragment()

    }

    private fun loadFragment(){
        /*
           newInstance:  Use this factory method to create a new instance of this
            fragment using the provided parameters.
         */
        supportFragmentManager
            .beginTransaction()
            .add(binding.searchFragment, SearchFragment.newInstance("Hello from Example"), "SearchFragment")
            .commit()


    }
}
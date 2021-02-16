package com.example.day14jobapi.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import android.view.WindowManager
import com.example.day14jobapi.R
import com.example.day14jobapi.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {



    //https://levelup.gitconnected.com/a-tutorial-on-building-a-splash-screen-with-kotlin-in-android-studio-dc647cd52f9b
    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT:Long = 5000 // 4 sec
    private lateinit var  binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,MainActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)

    }
}
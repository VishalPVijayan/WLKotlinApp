package com.wisdomleaf.wlkotlin.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.wisdomleaf.wlkotlin.MainActivity
import com.wisdomleaf.wlkotlin.R

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val backgroundImage: ImageView = findViewById(R.id.iv_splashScreen)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_animation)
        backgroundImage.startAnimation(slideAnimation)


        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000) // 5 seconds of delay


    }
}
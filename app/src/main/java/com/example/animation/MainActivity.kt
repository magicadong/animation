package com.example.animation

import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var animDrawable: AnimationDrawable
    lateinit var iv:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        /**
         * 动画尽量不要在onCreate中启动
         */
        iv = findViewById<ImageView>(R.id.iv_fire)
        //animDrawable = iv.drawable as AnimationDrawable
        //animDrawable.start()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN){

            val anim = iv.drawable as AnimatedVectorDrawable
            anim.start()


            // animDrawable.stop()
            //0. 使用AnimationUtils加载动画资源
//            val transAnim = AnimationUtils.loadAnimation(this,R.anim.translate_x_anim)
//            transAnim.interpolator = LinearInterpolator()
//            transAnim.repeatCount = Animation.INFINITE
//            transAnim.repeatMode = Animation.REVERSE
//            //1. 让控件使用对应的动画资源
//            iv.startAnimation(transAnim)

        }
        return true
    }
}
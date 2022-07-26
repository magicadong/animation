package com.example.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Explosion : AppCompatActivity() {
    lateinit var actionBtn:FloatingActionButton
    lateinit var bgView: View
    lateinit var scaleAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explosion)

        actionBtn = findViewById(R.id.floatingActionButton)
        bgView = findViewById(R.id.view)

        scaleAnimation = AnimationUtils.loadAnimation(this,R.anim.btn_scale_anim)


        actionBtn.setOnClickListener {
            actionBtn.visibility = View.INVISIBLE
            bgView.visibility = View.VISIBLE
            bgView.startAnimation(scaleAnimation)
        }
    }
}
package com.example.animation

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.*
import androidx.core.animation.addListener
import androidx.core.animation.addPauseListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    var dotLists = arrayListOf<FloatingActionButton>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        dotLists.add(menu1)
        dotLists.add(menu2)
        dotLists.add(menu3)
        menuBtn.setOnClickListener {

            val animator = ValueAnimator.ofInt(0,200)
            animator.duration = 1000
            animator.interpolator = BounceInterpolator()
            animator.addUpdateListener {
                val value = it.animatedValue as Int
                Log.v("pxd","$value")
            }
            animator.start()

            dotLists.forEachIndexed { index, floatingActionButton ->
                //setOpenAnimator(index)
                //setOpenAnim(index
            }
        }
    }

    fun scaleAnimator(){
        val xAnimator = ObjectAnimator.ofFloat(menuBtn,"scaleX",0.5f,2f,1f)
        val yAnimator = ObjectAnimator.ofFloat(menuBtn,"scaleY",0.5f,2f,1f)
        AnimatorSet().apply {
            duration = 500
            interpolator = BounceInterpolator()
            playTogether(xAnimator,yAnimator)
            start()
        }

    }

    /**
     * 一个对象只要能够提供set 和 get方法的属性都可以做动画
     */
    fun setOpenAnimator(index:Int){
        val menu = dotLists[index]

        menu.translationX
        val transAnimator = ObjectAnimator.ofFloat(menu,"translationX",0f,menu.width*2f)
        transAnimator.duration = 500
        transAnimator.interpolator = BounceInterpolator()
        transAnimator.addUpdateListener {
            val current = it.animatedValue as Float
        }
        transAnimator.addPauseListener {}
        transAnimator.addListener(
            onCancel = {},
            onStart = {},
            onEnd = {},
            onRepeat = {}
        )

        val rotateAnimator = ObjectAnimator.ofFloat(menu,"rotation",0f,360f)
        rotateAnimator.duration = 500
        rotateAnimator.interpolator = LinearInterpolator()

        val animators = AnimatorSet()
        animators.playTogether(transAnimator,rotateAnimator)
        animators.start()
    }

    fun setOpenAnim(index:Int){
        val menu = dotLists[index]

        val transAnim = TranslateAnimation(
            0f,menu.width*2f,0f,0f)

        val rotateAnim = RotateAnimation(
            0f,-45f*(index+1),0.5f*menu.width,0.5f*menu.width)

        val anims = AnimationSet(true)
        anims.addAnimation(transAnim)
        anims.addAnimation(rotateAnim)
        anims.interpolator = BounceInterpolator()
        anims.duration = 1000
        anims.fillAfter = true

        menu.startAnimation(anims)
    }

}
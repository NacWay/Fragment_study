package com.study.fragment_study.part1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.study.fragment_study.R

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val goFrABtn : Button = findViewById(R.id.toFragmentA)
        val fragmentA = Fragment_A()

        goFrABtn.setOnClickListener {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, fragmentA)
                addToBackStack(null)
                commit()
            }
        }

   }

}
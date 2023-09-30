package com.study.fragment_study.part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.fragment_study.R

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val personFragmentList = PersonList_Fragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, personFragmentList)
            addToBackStack(null)
            commit()
        }
    }
}
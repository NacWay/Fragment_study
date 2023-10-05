package com.study.fragment_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.Navigation
import com.study.fragment_study.part1.Activity1
import com.study.fragment_study.part2.Activity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val part1Btn : Button = findViewById(R.id.part1Btn)
        val part2Btn : Button = findViewById(R.id.part2Btn)

        part1Btn.setOnClickListener {
            val intent = Intent(this@MainActivity, Activity1::class.java)
            startActivity(intent)
        }

        part2Btn.setOnClickListener {
            val intent = Intent(this@MainActivity, Activity2::class.java)
            startActivity(intent)
        }
    }
}
package com.study.fragment_study.part1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.study.fragment_study.R

class Activity1 : AppCompatActivity() {
    private val router: Router = App().router
    private val navigatorHolder = App().navigatorHolder
    private val navigator = AppNavigator(this, R.id.fragmentContainer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)


        val goFrABtn : Button = findViewById(R.id.toFragmentA)

        /*
        fun FragmentA_Sscreen() = FragmentScreen { factory: FragmentFactory ->
            Fragment_A()
        }
         */

        fun FragmentA_Sscreen() = FragmentScreen { Fragment_A() }


        goFrABtn.setOnClickListener {
            router.navigateTo(FragmentA_Sscreen())
        }


   }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
package com.study.fragment_study.part1


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment



class Fragment_A : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.study.fragment_study.R.layout.fragment__a, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val goToFragmentB: Button = view.findViewById(com.study.fragment_study.R.id.toFragmentB)
        val fragmentB = Fragment_B()

        goToFragmentB.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(com.study.fragment_study.R.id.fragmentContainer, fragmentB)
                addToBackStack(null)
                hide(this@Fragment_A)
                commit()
            }
        }
    }
}
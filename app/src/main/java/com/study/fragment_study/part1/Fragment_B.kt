package com.study.fragment_study.part1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.study.fragment_study.R


class Fragment_B : Fragment() {






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val goToFrCbtn: Button = view.findViewById(R.id.toFragmentC)
        val back: Button = view.findViewById(R.id.backBtn)

        val fragmentA = Fragment_A()
        val fragmentC = Fragment_C()


        goToFrCbtn.setOnClickListener {
            val result = "Text from fragment B"
            parentFragmentManager.setFragmentResult("requestKey", bundleOf("bundleKey" to result))

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, fragmentC)
                addToBackStack(null)
                commit()
            }
        }


        back.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, fragmentA)
                commit()
            }
            }
        }
    }

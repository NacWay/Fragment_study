package com.study.fragment_study.part2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import com.study.fragment_study.R

class ChangeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_change, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("requestKey1", this) { requestKey, bundle ->
            val name = bundle.getString("keyName1")
            val number = bundle.getString("keyNum1")
            val position = bundle.getInt("position1")

            val enterName: EditText = view.findViewById(R.id.enterName)
            val enterNumber: EditText = view.findViewById(R.id.enterNumber)

            enterName.setText(name)
            enterNumber.setText(number)

            val saveBtn: Button = view.findViewById(R.id.saveBtn)
            val personlistFragment = PersonList_Fragment()

            saveBtn.setOnClickListener {
                parentFragmentManager.setFragmentResult(
                    "requestKey3",
                    bundleOf("keyName2" to enterName.text.toString(),
                        "keyNum2" to enterNumber.text.toString(),
                        "position2" to position
                    ))

                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainer, personlistFragment)
                    addToBackStack(null)
                    commit()
                }


            }

        }
    }
}
package com.study.fragment_study.part2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.os.bundleOf
import com.study.fragment_study.R
import com.study.recyclingview_study.contacts.Person


class PersonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            parentFragmentManager.setFragmentResultListener("requestKey", this) { requestKey, bundle ->
            val name = bundle.getString("keyName")
            val number = bundle.getString("keyNum")
            val position = bundle.getInt("position")

            val textName: TextView = view.findViewById(R.id.personName)
                textName.setText(name)
            val textNum: TextView = view.findViewById(R.id.personNum)
                textNum.setText(number)

            val changeFragment = ChangeFragment()
            val changeBtn : ImageButton = view.findViewById(R.id.changeBtn)
                changeBtn.setOnClickListener {
                    parentFragmentManager.setFragmentResult(
                        "requestKey1",
                        bundleOf("keyName1" to name,
                            "keyNum1" to number,
                            "position1" to position
                        )
                    )

                    parentFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainer, changeFragment)
                        addToBackStack(null)
                        commit()
                    }
                }
        }
    }

}
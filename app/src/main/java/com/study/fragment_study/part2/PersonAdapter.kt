package com.study.recyclingview_study.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.study.fragment_study.R
import com.study.fragment_study.part2.PersonFragment
import com.study.fragment_study.part2.PersonList_Fragment


class PersonAdapter(
    var personList: MutableList<Person>,
    val personFragment: PersonList_Fragment
)
    : RecyclerView.Adapter<PersonAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val phoneNumber: TextView = itemView.findViewById(R.id.phoneNumber)
        val name: TextView = itemView.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.person_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = personList.size


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = personList.get(position).name
        holder.phoneNumber.text = personList.get(position).number

        val personFragment1 = PersonFragment()
        //не знал как передать позицию тапнутого айтема в фрагмент, поэтому реализация тут:(
        holder.itemView.setOnClickListener {

            personFragment.parentFragmentManager.setFragmentResult(
                "requestKey",
                bundleOf("keyName" to personList[position].name,
                    "keyNum" to personList[position].number,
                    "position" to position
                    ))
            personFragment.parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, personFragment1)
                addToBackStack(null)
                commit()
            }
        }
    }
}
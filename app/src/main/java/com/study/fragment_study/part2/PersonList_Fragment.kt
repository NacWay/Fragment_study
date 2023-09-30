package com.study.fragment_study.part2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.study.fragment_study.R
import com.study.recyclingview_study.contacts.ContactAdapterDiffUtil
import com.study.recyclingview_study.contacts.PersonAdapter
import com.study.recyclingview_study.contacts.Person

class PersonList_Fragment : Fragment() {

    var personList = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //инициализация списка
        for (i in 0..5) {
            personList.add(Person("Name${i}", "+7${(2400000 + Math.random() * 2500000).toInt()}"))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_list_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            //регестируем список
            val recyclerView: RecyclerView = view.findViewById(R.id.recyclerContacts)
            recyclerView.layoutManager = LinearLayoutManager(context)
            val adapter =
                PersonAdapter(personList, this).also { recyclerView.adapter = it }

        //получаем измененные данные из фрагмента changedPerson и добавляем в список с помощтю DiffUtil
        parentFragmentManager.setFragmentResultListener("requestKey3", this) { requestKey, bundle ->
            val name = bundle.getString("keyName2")
            val number = bundle.getString("keyNum2")
            val position = bundle.getInt("position2")
            adapter.personList.add(position, Person(name.toString(), number.toString()))

            val contactsDiffUtil =
                ContactAdapterDiffUtil(adapter.personList, personList)
            val contatsDiffResult = DiffUtil.calculateDiff(contactsDiffUtil)
            adapter.personList.removeAt(position+1)
            contatsDiffResult.convertOldPositionToNew(position)
        }
    }
}

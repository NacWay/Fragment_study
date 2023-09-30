package com.study.recyclingview_study.contacts

import androidx.recyclerview.widget.DiffUtil

class ContactAdapterDiffUtil(oldList: List<Person>, newList: List<Person>) :
    DiffUtil.Callback() {
    private val oldList: List<Person>
    private val newList: List<Person>

    init {
        this.oldList = oldList
        this.newList = newList
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldContacts: Person = oldList[oldItemPosition]
        val newContacts: Person = newList[newItemPosition]
        return oldContacts.name == newContacts.name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldList: Person = oldList[oldItemPosition]
        val newList: Person = newList[newItemPosition]
        return (oldList.name.equals(newList.name)
                && oldList.number === newList.number)
    }
}
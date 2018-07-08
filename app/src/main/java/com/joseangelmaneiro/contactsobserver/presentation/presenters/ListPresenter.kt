package com.joseangelmaneiro.contactsobserver.presentation.presenters

import com.joseangelmaneiro.contactsobserver.data.Contact
import com.joseangelmaneiro.contactsobserver.data.Observer
import com.joseangelmaneiro.contactsobserver.data.Repository
import com.joseangelmaneiro.contactsobserver.presentation.views.CellView
import com.joseangelmaneiro.contactsobserver.presentation.views.ListView
import java.lang.ref.WeakReference


class ListPresenter(listView: ListView,
                    private val repository: Repository): Observer {

    private val view: WeakReference<ListView> = WeakReference(listView)
    private var items = emptyList<Contact>()

    fun viewReady(){
        repository.subscribe(this)
        val contacts = repository.getContacts()
        saveItems(contacts)
        view.get()?.refreshList()
    }

    fun getItemsCount(): Int{
        return if(!listIsEmpty()) items.size else 0
    }

    fun configureCell(cellView: CellView, position: Int){
        cellView.displayName(getContactName(position))
    }

    fun onItemClick(position: Int){
        view.get()?.openDetailScreen(getContactName(position))
    }

    fun onDestroy(){
        repository.unsubscribe(this)
    }

    override fun update(contacts: List<Contact>) {
        saveItems(contacts)
        view.get()?.refreshList()
    }

    private fun saveItems(items: List<Contact>){
        this.items = items
    }

    private fun listIsEmpty(): Boolean{
        return items.isEmpty()
    }

    private fun getContactName(position: Int): String{
        return items[position].name
    }

}
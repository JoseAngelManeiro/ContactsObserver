package com.joseangelmaneiro.contactsobserver.platform.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.joseangelmaneiro.contactsobserver.R
import com.joseangelmaneiro.contactsobserver.presentation.presenters.ListPresenter
import com.joseangelmaneiro.contactsobserver.presentation.views.CellView
import kotlinx.android.synthetic.main.item_contact.view.*


class ContactsAdapter(private val presenter: ListPresenter):
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_contact, parent, false)
        return ContactHolder(view)
    }

    override fun getItemCount(): Int {
        return presenter.getItemsCount()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        presenter.configureCell(holder as CellView, position)
    }

    inner class ContactHolder(itemView: View): RecyclerView.ViewHolder(itemView), CellView {

        private val nameView: TextView = itemView.nameTextView

        init {
            nameView.setOnClickListener { presenter.onItemClick(adapterPosition) }
        }

        override fun displayName(name: String) {
            nameView.text = name
        }
    }

    fun refreshList(){
        notifyDataSetChanged()
    }

}
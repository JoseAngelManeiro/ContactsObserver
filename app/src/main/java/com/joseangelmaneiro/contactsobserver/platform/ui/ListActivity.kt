package com.joseangelmaneiro.contactsobserver.platform.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.joseangelmaneiro.contactsobserver.R
import com.joseangelmaneiro.contactsobserver.presentation.presenters.ListPresenter
import com.joseangelmaneiro.contactsobserver.presentation.views.ListView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject


class ListActivity : DaggerAppCompatActivity(), ListView {

    @Inject
    lateinit var presenter: ListPresenter

    private lateinit var contactsAdapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        setUpRecyclerView()

        setUpAddButton()

        presenter.viewReady()
    }

    private fun setUpRecyclerView(){
        contactsAdapter = ContactsAdapter(presenter)
        recyclerView.apply {
            adapter = contactsAdapter
            addItemDecoration(DividerItemDecoration(context,
                    LinearLayoutManager.VERTICAL))
        }
    }

    private fun setUpAddButton(){
        addButton.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    override fun refreshList() {
        contactsAdapter.refreshList()
    }

    override fun openDetailScreen(name: String) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, name)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}

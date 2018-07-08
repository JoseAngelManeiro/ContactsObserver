package com.joseangelmaneiro.contactsobserver.platform.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.joseangelmaneiro.contactsobserver.R
import com.joseangelmaneiro.contactsobserver.presentation.presenters.AddPresenter
import com.joseangelmaneiro.contactsobserver.presentation.views.AddView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*
import javax.inject.Inject


class AddActivity : DaggerAppCompatActivity(), AddView {

    @Inject
    lateinit var presenter: AddPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        setUpActionBar()
    }

    private fun setUpActionBar(){
        supportActionBar?.let { actionBar ->
            actionBar.title = "Add contact"
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun closeScreen() {
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.menu_add -> {
                presenter.createContact(nameEditText.text.toString(),
                        phoneEditText.text.toString())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

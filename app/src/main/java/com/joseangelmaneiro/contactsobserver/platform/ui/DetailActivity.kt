package com.joseangelmaneiro.contactsobserver.platform.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.joseangelmaneiro.contactsobserver.R
import com.joseangelmaneiro.contactsobserver.presentation.presenters.DetailPresenter
import com.joseangelmaneiro.contactsobserver.presentation.views.DetailView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject


class DetailActivity : DaggerAppCompatActivity(), DetailView {

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    @Inject
    lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setUpActionBar()

        presenter.viewReady()
    }

    private fun setUpActionBar(){
        supportActionBar?.let { actionBar ->
            actionBar.title = "Contact detail"
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun displayName(name: String) {
        nameTextView.text = name
    }

    override fun displayPhone(phone: String) {
        phoneTextView.text = phone
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun closeScreen() {
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.menu_delete -> {
                presenter.deleteContact()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

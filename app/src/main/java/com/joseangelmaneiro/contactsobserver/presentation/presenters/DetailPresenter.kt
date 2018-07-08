package com.joseangelmaneiro.contactsobserver.presentation.presenters

import com.joseangelmaneiro.contactsobserver.data.Contact
import com.joseangelmaneiro.contactsobserver.data.Repository
import com.joseangelmaneiro.contactsobserver.presentation.views.DetailView
import java.lang.ref.WeakReference


class DetailPresenter(detailView: DetailView,
                      private val contactName: String,
                      private val repository: Repository) {

    private val view: WeakReference<DetailView> = WeakReference(detailView)
    private lateinit var contact: Contact

    fun viewReady(){
        contact = repository.getContact(contactName)
        view.get()?.let { detailView ->
            detailView.displayName(contact.name)
            detailView.displayPhone(contact.phone)
        }
    }

    fun deleteContact(){
        repository.deleteContact(contact.name)
        view.get()?.let { detailView ->
            detailView.showMessage("El contacto se ha eliminado")
            detailView.closeScreen()
        }
    }

}
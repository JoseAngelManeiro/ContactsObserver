package com.joseangelmaneiro.contactsobserver.presentation.presenters

import com.joseangelmaneiro.contactsobserver.data.Contact
import com.joseangelmaneiro.contactsobserver.data.Repository
import com.joseangelmaneiro.contactsobserver.presentation.views.AddView
import java.lang.ref.WeakReference


class AddPresenter(addView: AddView,
                   private val repository: Repository) {

    private val view: WeakReference<AddView> = WeakReference(addView)

    fun createContact(name: String, phone: String){
        if(name.isEmpty() || phone.isEmpty()){
            view.get()?.showMessage("Los campos son obligatorios")
        } else{
            repository.addContact(Contact(name, phone))
            view.get()?.let { addView ->
                addView.showMessage("Se ha creado un nuevo contacto")
                addView.closeScreen()
            }
        }
    }

}
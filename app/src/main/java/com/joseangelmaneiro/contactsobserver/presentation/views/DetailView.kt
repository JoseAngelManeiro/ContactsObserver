package com.joseangelmaneiro.contactsobserver.presentation.views


interface DetailView {

    fun displayName(name: String)

    fun displayPhone(phone: String)

    fun showMessage(message: String)

    fun closeScreen()

}
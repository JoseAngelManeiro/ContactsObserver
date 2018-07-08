package com.joseangelmaneiro.contactsobserver.data


interface Observer {

    fun update(contacts: List<Contact>)

}
package com.joseangelmaneiro.contactsobserver.data


interface Repository: Observable {

    fun getContacts(): List<Contact>

    fun getContact(name: String): Contact

    fun addContact(contact: Contact)

    fun deleteContact(name: String)

}
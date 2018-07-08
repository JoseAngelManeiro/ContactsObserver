package com.joseangelmaneiro.contactsobserver.data

import javax.inject.Inject


class RepositoryImpl @Inject constructor(): Repository {

    private val contacts = createContacts()
    private val observers = mutableListOf<Observer>()

    override fun getContacts(): List<Contact> {
        return contacts.values.toList()
    }

    override fun getContact(name: String): Contact {
        return contacts[name]!!
    }

    override fun addContact(contact: Contact) {
        contacts[contact.name] = contact
        notifyObservers()
    }

    override fun deleteContact(name: String) {
        contacts.remove(name)
        notifyObservers()
    }

    override fun subscribe(observer: Observer) {
        observers.add(observer)
    }

    override fun unsubscribe(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for(observer in observers){
            observer.update(contacts.values.toList())
        }
    }

    private fun createContacts(): MutableMap<String, Contact>{
        //Create contact list
        val contacts = listOf(
                Contact("María Vivas", "612345678"),
                Contact("Jesús Manuel", "623456789"),
                Contact("José Martínez", "634567890"),
                Contact("Dolores González", "645678901"),
                Contact("Prudencia Martínez", "656789012"))
        //Populate map
        val map = mutableMapOf<String, Contact>()
        for (contact in contacts){
            map[contact.name] = contact
        }
        return map
    }

}
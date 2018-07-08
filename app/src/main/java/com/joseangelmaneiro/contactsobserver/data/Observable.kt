package com.joseangelmaneiro.contactsobserver.data


interface Observable {

    fun subscribe(observer: Observer)

    fun unsubscribe(observer: Observer)

    fun notifyObservers()

}
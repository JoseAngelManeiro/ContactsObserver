package com.joseangelmaneiro.contactsobserver.platform

import com.joseangelmaneiro.contactsobserver.platform.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class ContactApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<ContactApp> {
        val component = DaggerAppComponent.builder().application(this).build();
        component.inject(this);
        return component
    }

}
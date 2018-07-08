package com.joseangelmaneiro.contactsobserver.platform.di.app

import android.app.Application
import com.joseangelmaneiro.contactsobserver.platform.ContactApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton
import dagger.BindsInstance


@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class])
interface AppComponent: AndroidInjector<ContactApp> {

    override fun inject(app: ContactApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}
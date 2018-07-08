package com.joseangelmaneiro.contactsobserver.platform.di.modules

import com.allianz.proveedores.platform.di.PerActivity
import com.joseangelmaneiro.contactsobserver.data.Repository
import com.joseangelmaneiro.contactsobserver.platform.ui.ListActivity
import com.joseangelmaneiro.contactsobserver.presentation.presenters.ListPresenter
import dagger.Module
import dagger.Provides


@Module
class ListModule {

    @Provides
    @PerActivity
    fun providePresenter(listActivity: ListActivity,
                         repository: Repository): ListPresenter {
        return ListPresenter(listActivity, repository)
    }

}
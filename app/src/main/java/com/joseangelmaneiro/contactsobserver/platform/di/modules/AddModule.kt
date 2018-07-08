package com.joseangelmaneiro.contactsobserver.platform.di.modules

import com.allianz.proveedores.platform.di.PerActivity
import com.joseangelmaneiro.contactsobserver.data.Repository
import com.joseangelmaneiro.contactsobserver.platform.ui.AddActivity
import com.joseangelmaneiro.contactsobserver.presentation.presenters.AddPresenter
import dagger.Module
import dagger.Provides


@Module
class AddModule {

    @Provides
    @PerActivity
    fun providePresenter(addActivity: AddActivity,
                         repository: Repository): AddPresenter {
        return AddPresenter(addActivity, repository)
    }

}
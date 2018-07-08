package com.joseangelmaneiro.contactsobserver.platform.di.modules

import com.allianz.proveedores.platform.di.PerActivity
import com.joseangelmaneiro.contactsobserver.data.Repository
import com.joseangelmaneiro.contactsobserver.platform.ui.DetailActivity
import com.joseangelmaneiro.contactsobserver.presentation.presenters.DetailPresenter
import dagger.Module
import dagger.Provides


@Module
class DetailModule {

    @Provides
    @PerActivity
    fun providePresenter(detailActivity: DetailActivity,
                         repository: Repository): DetailPresenter {
        val contactName = detailActivity.intent.getStringExtra(DetailActivity.EXTRA_ID)
        return DetailPresenter(detailActivity, contactName, repository)
    }

}
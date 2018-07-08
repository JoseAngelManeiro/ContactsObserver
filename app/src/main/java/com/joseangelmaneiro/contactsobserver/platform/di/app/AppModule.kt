package com.joseangelmaneiro.contactsobserver.platform.di.app

import com.joseangelmaneiro.contactsobserver.data.Repository
import com.joseangelmaneiro.contactsobserver.data.RepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
open class AppModule {

    @Provides
    @Singleton
    fun provideRepository(): Repository {
        return RepositoryImpl()
    }

}
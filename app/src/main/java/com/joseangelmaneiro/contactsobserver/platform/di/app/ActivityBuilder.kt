package com.joseangelmaneiro.contactsobserver.platform.di.app

import com.allianz.proveedores.platform.di.PerActivity
import com.joseangelmaneiro.contactsobserver.platform.ui.AddActivity
import com.joseangelmaneiro.contactsobserver.platform.ui.DetailActivity
import com.joseangelmaneiro.contactsobserver.platform.ui.ListActivity
import com.joseangelmaneiro.contactsobserver.platform.di.modules.AddModule
import com.joseangelmaneiro.contactsobserver.platform.di.modules.DetailModule
import com.joseangelmaneiro.contactsobserver.platform.di.modules.ListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(ListModule::class)])
    @PerActivity
    internal abstract fun bindListActivity(): ListActivity

    @ContributesAndroidInjector(modules = [(DetailModule::class)])
    @PerActivity
    internal abstract fun bindDetailActivity(): DetailActivity

    @ContributesAndroidInjector(modules = [(AddModule::class)])
    @PerActivity
    internal abstract fun bindAddActivity(): AddActivity

}
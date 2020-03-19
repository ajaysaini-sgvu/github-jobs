package com.github.jobs.android.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.github.jobs.android.ui.base.ViewModelFactory
import com.github.jobs.android.ui.base.ViewModelKey
import com.github.jobs.android.ui.jobs.JobsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(JobsListViewModel::class)
    internal abstract fun jobsListViewModel(viewModel: JobsListViewModel): ViewModel
}
//Add ViewModels here

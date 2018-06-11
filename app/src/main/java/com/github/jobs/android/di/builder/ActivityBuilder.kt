package com.github.jobs.android.di.builder

import com.github.jobs.android.ui.jobs.JobsListActivity
import com.github.jobs.android.ui.jobs.JobsListActivityModule
import com.github.jobs.android.ui.jobs.JobsListFragment
import com.github.jobs.android.ui.jobs.JobsListFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = arrayOf(JobsListActivityModule::class))
    internal abstract fun bindJobsListActivity(): JobsListActivity

    @ContributesAndroidInjector(modules = arrayOf(JobsListFragmentModule::class))
    internal abstract fun jobsListFragment(): JobsListFragment

}
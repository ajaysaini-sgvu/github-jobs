package com.github.jobs.android.ui.jobs

import dagger.Module
import com.github.jobs.android.utils.rx.SchedulerProvider
import com.github.jobs.android.data.DataManager
import dagger.Provides

@Module
class JobsListActivityModule {

    @Provides
    fun provideJobsListViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider): JobsListViewModel {
        return JobsListViewModel(dataManager, schedulerProvider)
    }
}
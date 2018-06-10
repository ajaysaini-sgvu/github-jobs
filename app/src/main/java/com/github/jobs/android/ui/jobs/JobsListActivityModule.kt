package com.github.jobs.android.ui.jobs

import dagger.Module
import com.github.jobs.android.utils.rx.SchedulerProvider
import com.github.jobs.android.data.DataManager
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class JobsListActivityModule {

    @Provides
    fun provideJobsListViewModel(): JobsListViewModel {
        return JobsListViewModel()
    }
}
package com.github.jobs.android.ui.jobs

import com.github.jobs.android.data.DataManager
import com.github.jobs.android.data.model.api.jobs.JobsResponse
import com.github.jobs.android.data.remote.CallbackWrapper
import com.github.jobs.android.ui.base.BaseViewModel
import com.github.jobs.android.utils.AppLogger
import com.github.jobs.android.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class JobsListViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<JobsListNavigator>(dataManager, schedulerProvider) {

    fun jobs() {
        setIsLoading(true)
        compositeDisposable.add(dataManager.getJobsApiCall().subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
                .subscribeWith(object: CallbackWrapper<List<JobsResponse>>() {
                    override fun onSuccess(t: List<JobsResponse>) {
                        setIsLoading(false)
                    }
                    override fun onError(any: Any) {
                        setIsLoading(false)
                        navigator.handleError(any)
                    }
                }))
    }
}
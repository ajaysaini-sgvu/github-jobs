package com.github.jobs.android.ui.jobs

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.github.jobs.android.data.DataManager
import com.github.jobs.android.data.model.api.jobs.JobsResponse
import com.github.jobs.android.data.remote.CallbackWrapper
import com.github.jobs.android.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class JobsListViewModel @Inject constructor(private val dataManager: DataManager, private val schedulerProvider: SchedulerProvider) : ViewModel() {

    var jobsList: MutableLiveData<List<JobsResponse>>? = null

    private val compositeDisposable = CompositeDisposable()

    fun getJobs(): LiveData<List<JobsResponse>>? {
        if (jobsList == null) {
            jobsList = MutableLiveData()
            loadJobs()
        }
        return jobsList
    }

    private fun loadJobs() {
        compositeDisposable.add(dataManager.getJobsApiCall().subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
                .subscribeWith(object : CallbackWrapper<List<JobsResponse>>() {
                    override fun onSuccess(t: List<JobsResponse>) {
                        jobsList!!.value = t
                    }

                    override fun onError(any: Any) {
                        // handle error
                    }
                }))
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}
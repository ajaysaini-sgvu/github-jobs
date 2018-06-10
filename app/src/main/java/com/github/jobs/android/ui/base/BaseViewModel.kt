package com.github.jobs.android.ui.base

import com.github.jobs.android.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import android.arch.lifecycle.ViewModel
import java.lang.ref.WeakReference
import android.databinding.ObservableBoolean;
import com.github.jobs.android.data.DataManager

abstract class BaseViewModel<N>(val dataManager: DataManager,
                                val schedulerProvider: SchedulerProvider) : ViewModel() {

    private val isLoading = ObservableBoolean(false)

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private var mNavigator: WeakReference<N>? = null

    var navigator: N
        get() = mNavigator!!.get()!!
        set(navigator) {
            this.mNavigator = WeakReference(navigator)
        }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }
}

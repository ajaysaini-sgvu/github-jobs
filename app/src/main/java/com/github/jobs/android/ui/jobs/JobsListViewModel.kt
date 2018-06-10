package com.github.jobs.android.ui.jobs

import com.github.jobs.android.data.DataManager
import com.github.jobs.android.ui.base.BaseViewModel
import com.github.jobs.android.utils.rx.SchedulerProvider

class JobsListViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<JobsListNavigator>(dataManager, schedulerProvider)
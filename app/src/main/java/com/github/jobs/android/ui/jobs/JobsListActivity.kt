package com.github.jobs.android.ui.jobs

import android.os.Bundle
import com.github.jobs.android.BR
import com.github.jobs.android.R
import com.github.jobs.android.databinding.ActivityJobsListBinding
import com.github.jobs.android.ui.base.BaseActivity
import javax.inject.Inject

class JobsListActivity : BaseActivity<ActivityJobsListBinding, JobsListViewModel>(), JobsListNavigator {

    @Inject
    lateinit var jobsListViewModel: JobsListViewModel

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_jobs_list

    override val viewModel: JobsListViewModel
        get() = jobsListViewModel

    private var activityJobsListBinding: ActivityJobsListBinding? = null

    override fun handleError(throwable: Throwable) {
        // handle errors
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityJobsListBinding = viewDataBinding

        jobsListViewModel.jobs()
    }
}

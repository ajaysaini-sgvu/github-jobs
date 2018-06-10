package com.github.jobs.android.ui.jobs

import android.os.Bundle
import com.github.jobs.android.BR
import com.github.jobs.android.R
import com.github.jobs.android.databinding.ActivityJobsListBinding
import com.github.jobs.android.ui.base.BaseActivity

class JobsListActivity : BaseActivity<ActivityJobsListBinding, JobsListViewModel>(), JobsListNavigator {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_jobs_list

    override val viewModel: JobsListViewModel
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    private var activityJobsListBinding: ActivityJobsListBinding? = null

    override fun handleError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityJobsListBinding = viewDataBinding
    }
}

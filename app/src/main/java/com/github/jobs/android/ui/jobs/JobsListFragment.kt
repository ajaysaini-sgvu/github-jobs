package com.github.jobs.android.ui.jobs

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.jobs.android.R
import com.github.jobs.android.databinding.FragmentJobsListBinding
import com.github.jobs.android.utils.AppLogger
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class JobsListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var fragmentJobsListBinding: FragmentJobsListBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentJobsListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_jobs_list, container, false)

        return fragmentJobsListBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val jobsListViewModel = ViewModelProviders.of(this, viewModelFactory).get(JobsListViewModel::class.java)
        subscribeUi(jobsListViewModel)
    }

    private fun subscribeUi(jobsListViewModel: JobsListViewModel) {
        jobsListViewModel.getJobs()!!.observe(this, Observer {
            it!!.forEach { jobsResponse -> AppLogger.d(JobsListFragment::class.qualifiedName, jobsResponse.company + "") }
        })
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
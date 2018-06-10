package com.github.jobs.android.ui.jobs

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.jobs.android.R
import com.github.jobs.android.databinding.FragmentJobsListBinding

class JobsListFragment : Fragment() {

    var fragmentJobsListBinding: FragmentJobsListBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        fragmentJobsListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_jobs_list, container, false)
        
        return fragmentJobsListBinding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val jobsListViewModel = ViewModelProviders.of(this).get(JobsListViewModel::class.java)
        subscribeUi(jobsListViewModel)
    }

    fun subscribeUi(jobsListViewModel: JobsListViewModel) {

    }
}
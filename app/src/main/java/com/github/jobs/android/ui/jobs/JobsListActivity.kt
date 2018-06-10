package com.github.jobs.android.ui.jobs

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.jobs.android.R

class JobsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobs)

        // Add jobs list fragment if this is first creation
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, JobsListFragment()).commit()
        }
    }

}

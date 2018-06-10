package com.github.jobs.android

import com.github.jobs.android.utils.AppLogger
import android.app.Activity
import android.app.Application
import com.github.jobs.android.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import dagger.android.HasActivityInjector

class GitHubJobsApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): DispatchingAndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)

        AppLogger.init()
    }
}
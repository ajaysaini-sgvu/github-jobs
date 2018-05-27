package com.github.jobs.android

import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.androidnetworking.AndroidNetworking
import com.github.jobs.android.utils.AppLogger
import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject
import dagger.android.HasActivityInjector


class MvvmApp : Application(), HasActivityInjector {

    @Inject
    internal var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    @Inject
    internal var mCalligraphyConfig: CalligraphyConfig? = null

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()

//        DaggerAppComponent.builder()
//                .application(this)
//                .build()
//                .inject(this)

        AppLogger.init()

        AndroidNetworking.initialize(getApplicationContext())
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig)
    }
}
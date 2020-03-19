package com.github.jobs.android.di.module

import android.app.Application
import com.github.jobs.android.utils.rx.AppSchedulerProvider
import com.github.jobs.android.utils.rx.SchedulerProvider
import dagger.Provides
import com.github.jobs.android.data.pref.PreferencesHelper
import javax.inject.Singleton
import com.github.jobs.android.data.pref.AppPreferencesHelper
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import com.github.jobs.android.data.AppDataManager
import com.github.jobs.android.data.DataManager
import android.content.Context
import com.github.jobs.android.data.remote.ApiHelper
import com.github.jobs.android.data.remote.ApiHelperImpl
import dagger.Module

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApiHelper(apiHelperImpl: ApiHelperImpl): ApiHelper = apiHelperImpl

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager = appDataManager

    @Provides
    @Singleton
    internal fun provideGson(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper = appPreferencesHelper

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()
}
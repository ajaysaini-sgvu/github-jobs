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
import dagger.Module

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: ApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }
}
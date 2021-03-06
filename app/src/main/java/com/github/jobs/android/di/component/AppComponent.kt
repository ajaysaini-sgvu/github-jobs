package com.github.jobs.android.di.component

import android.app.Application
import com.github.jobs.android.GitHubJobsApp
import com.github.jobs.android.di.builder.ActivityBuilder
import com.github.jobs.android.di.module.AppModule
import com.github.jobs.android.di.module.NetworkModule
import com.github.jobs.android.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ViewModelModule::class, NetworkModule::class, ActivityBuilder::class))
interface AppComponent {

    fun inject(app: GitHubJobsApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
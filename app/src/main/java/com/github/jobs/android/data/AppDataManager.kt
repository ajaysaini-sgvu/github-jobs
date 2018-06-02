package com.github.jobs.android.data

import android.content.Context
import com.github.jobs.android.data.pref.PreferencesHelper
import com.github.jobs.android.data.remote.ApiHelper
import javax.inject.Inject

open class AppDataManager @Inject constructor(private val preferencesHelper: PreferencesHelper,
                                              private val apiHelper: ApiHelper,
                                              private val context: Context) : DataManager {

}
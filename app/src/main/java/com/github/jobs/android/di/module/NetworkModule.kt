package com.github.jobs.android.di.module

import android.content.Context
import com.github.jobs.android.BuildConfig
import com.github.jobs.android.data.remote.ApiKeyInterceptor
import com.github.jobs.android.data.remote.RestApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val CONNECTION_TIMEOUT_SECS: Long = 20

private const val HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = (5 * 1024 * 1024).toLong()

@Module
class NetworkModule {

    @Provides
    fun provideCacheFile(context: Context): Cache {
        val baseDir = context.cacheDir
        val cacheDir = File(baseDir, "HttpResponseCache")
        return Cache(cacheDir, HTTP_RESPONSE_DISK_CACHE_MAX_SIZE)
    }

    @Provides
    @Singleton
    fun provideMoshiConverterLibrary(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun providesRxJava2CallAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(cache: Cache?, apiKeyInterceptor: ApiKeyInterceptor): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        if (cache != null) {
            okHttpClientBuilder.cache(cache)
        }

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(logging)
        }

        okHttpClientBuilder
                .connectTimeout(CONNECTION_TIMEOUT_SECS, TimeUnit.SECONDS)
                .readTimeout(CONNECTION_TIMEOUT_SECS, TimeUnit.SECONDS)
                .writeTimeout(CONNECTION_TIMEOUT_SECS, TimeUnit.SECONDS)

        okHttpClientBuilder.addInterceptor(apiKeyInterceptor)

        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRestApiHelper(
            okHttpClient: OkHttpClient,
            moshiConverterFactory: MoshiConverterFactory,
            rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): RestApi {
        val builder = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(moshiConverterFactory)
        val retrofit = builder.client(okHttpClient).build()
        return retrofit.create(RestApi::class.java)
    }
}
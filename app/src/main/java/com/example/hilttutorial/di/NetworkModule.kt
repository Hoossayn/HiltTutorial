package com.example.hilttutorial.di


import com.example.hilttutorial.BuildConfig
import com.example.hilttutorial.constants.Constant.Companion.BASE_URL
import com.example.hilttutorial.data.network.MyApi
import com.example.hilttutorial.data.network.MyApiHelper
import com.example.hilttutorial.data.network.MyApiHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()
    } else OkHttpClient
            .Builder()
            .build()


    @Provides
    @Singleton
    fun provideRetrofit(
            okHttpClient: OkHttpClient,
            BASE_URL: String
    ): Retrofit =
            Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): MyApi = retrofit.create(MyApi::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: MyApiHelperImpl): MyApiHelper = apiHelper

}
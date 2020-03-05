package com.marekfeifrlik.api

import com.marekfeifrlik.common.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Marek Feifrlik on 05/03/2020.
 */
class ApiClient {

    private var retrofit: Retrofit? = null

    private fun okHttpClient(): OkHttpClient.Builder {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(2, TimeUnit.MINUTES)
        okHttpClient.readTimeout(2, TimeUnit.MINUTES)
        okHttpClient.writeTimeout(2, TimeUnit.MINUTES)

        return okHttpClient
    }

    fun getRetrofit(): Retrofit {
        val okhttpBuilder = okHttpClient()
        when (retrofit) {
            null -> retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpBuilder.build())
                .build()
        }
        return retrofit as Retrofit
    }

}

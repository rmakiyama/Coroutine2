package com.okuzawats.comcoroutine

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    companion object {
        val instance: GitHubApi = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(GitHubApi::class.java)
    }

    @GET("users/{user_name}")
    fun fetchUserAsync(@Path("user_name") userName: String): Deferred<GitHubUser>
}
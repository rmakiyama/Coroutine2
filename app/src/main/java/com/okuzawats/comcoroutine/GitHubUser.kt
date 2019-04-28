package com.okuzawats.comcoroutine

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitHubUser(
        val name: String,
        val id: String,
        @Json(name = "avatar_url")
        val avatarUrl: String
)
package com.okuzawats.comcoroutine

import com.google.gson.annotations.SerializedName

data class GitHubUser(
        val name: String,
        val id: String,
        @SerializedName("avatar_url")
        val avatarUrl: String
)
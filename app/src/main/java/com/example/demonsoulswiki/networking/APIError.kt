package com.example.demonsoulswiki.networking

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class APIError(val message: String)
package com.example.cryptoapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LinksExtended(
    val type: String,
    val url: String
)
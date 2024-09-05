package com.example.teste_willowtree.data.models

import com.google.gson.annotations.SerializedName

data class SocialLink(
    @SerializedName("callToAction")
    val callToAction: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)
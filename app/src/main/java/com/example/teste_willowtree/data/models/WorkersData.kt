package com.example.teste_willowtree.data.models

import com.google.gson.annotations.SerializedName

data class WorkersData(
    @SerializedName("bio")
    val bio: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("headshot")
    val headshot: Headshot,
    @SerializedName("id")
    val id: String,
    @SerializedName("jobTitle")
    val jobTitle: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("socialLinks")
    val socialLinks: List<SocialLink>,
    @SerializedName("type")
    val type: String
)
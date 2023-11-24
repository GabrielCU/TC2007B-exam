package com.example.examen.data.network.models

import com.google.gson.annotations.SerializedName

data class Cases(
    @SerializedName("total") val total: Int,
    @SerializedName("new") val new: Int, 
)
package com.example.examen.data.network.models

data class CovidObject(
    val cases: Map<String, Result>,
    val country: String,
    val region: String
)
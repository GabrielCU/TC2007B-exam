package com.example.examen.data.network

import com.example.examen.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModuleDI {

	private val gsonFactory : GsonConverterFactory = GsonConverterFactory.create()
	private val okHttpClient : OkHttpClient = OkHttpClient.Builder().build()

	operator fun invoke(): CovidAPIService {
		return Retrofit.Builder()
			.baseUrl(Constants.BASE_URL)
			.client(okHttpClient)
			.addConverterFactory(gsonFactory)
			.build()
			.create(CovidAPIService::class.java)
	}
}
package com.example.dota2herowiki.network

import com.example.dota2herowiki.dataHolder.DataModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object RetrofitClient {
    private const val BASE_URL = "https://us.api.blizzard.com/"

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val retrofitBuilder by lazy{
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    fun getInformation(): Apartments = retrofitBuilder.create(Apartments::class.java)
}


interface Apartments{
    @GET("hearthstone/cards?locale=en_US&gameMode=battlegrounds&tier=1%2C2%2C3%2C4%2C5%2C6&access_token=USrLSxkvQriPdWnfWn0L3NxKvwZrnJuQQP&pageSize=200")
    suspend fun getInfo(): Response<DataModel>

    @GET("hearthstone/cards?locale=en_US&gameMode=battlegrounds&tier=1&access_token=USrLSxkvQriPdWnfWn0L3NxKvwZrnJuQQP&pageSize=200")
    suspend fun getTavernTier(): Response<DataModel>

    @GET("hearthstone/cards?locale=en_US&gameMode=battlegrounds&tier=2&access_token=USrLSxkvQriPdWnfWn0L3NxKvwZrnJuQQP&pageSize=200")
    suspend fun getSecondTavernTier():Response<DataModel>

    @GET("hearthstone/cards?locale=en_US&gameMode=battlegrounds&tier=3&access_token=USrLSxkvQriPdWnfWn0L3NxKvwZrnJuQQP&pageSize=200")
    suspend fun getThirdTavernTier():Response<DataModel>

    @GET("hearthstone/cards?locale=en_US&gameMode=battlegrounds&tier=4&access_token=USrLSxkvQriPdWnfWn0L3NxKvwZrnJuQQP&pageSize=200")
    suspend fun getFourthTavernTier():Response<DataModel>

    @GET("hearthstone/cards?locale=en_US&gameMode=battlegrounds&tier=5&access_token=USrLSxkvQriPdWnfWn0L3NxKvwZrnJuQQP&pageSize=200")
    suspend fun getFifthTavernTier():Response<DataModel>

    @GET("hearthstone/cards?locale=en_US&gameMode=battlegrounds&tier=6&access_token=USrLSxkvQriPdWnfWn0L3NxKvwZrnJuQQP&pageSize=200")
    suspend fun getSixthTavernTier():Response<DataModel>
}

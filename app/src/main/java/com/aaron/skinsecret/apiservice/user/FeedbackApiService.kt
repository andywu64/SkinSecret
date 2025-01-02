package com.aaron.skinsecret.apiservice.user

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.aaron.skinsecret.dataclass.user.Feedback
import com.aaron.skinsecret.util.LocalDateTimeTypeAdapter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query
import java.time.LocalDateTime

interface FeedbackApiService {
    @GET("feedback")
    suspend fun getItem(@Query("id") id: Int): Feedback

    @GET("feedback")
    suspend fun getAllItems(): List<Feedback>

    @POST("feedback")
    suspend fun createItem(@Body request: Feedback): Int

    @PUT("feedback")
    suspend fun updateItem(
        @Body updateRequest: Feedback
    ): Int

    @DELETE("feedback")
    suspend fun deleteItem(@Query("id") id: Int): Response<Unit>
}

@SuppressLint("NewApi")
object FeedbackAipInstance {
    private const val BASE_URL = "http://10.0.2.2:8080/skin-sercet-maven/rest/user/"

    @RequiresApi(Build.VERSION_CODES.O)
    private val gson: Gson = GsonBuilder()
        .setDateFormat("yyyy/MM/dd HH:mm:ss")
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeTypeAdapter())
        .create()

    val api: FeedbackApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(FeedbackApiService::class.java)
    }
}
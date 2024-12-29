package com.aaron.skinsecret.apiservice.user.maintain

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.aaron.skinsecret.dataclass.user.maintain.Maintain
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
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDateTime


interface MaintainApiService {
    @GET("maintains")
    suspend fun getMaintain(@Query("id") id: Int): Maintain

    @GET("maintains")
    suspend fun getAllMaintain(): List<Maintain>

    //@GET("/")
    //suspend fun getMaintains(@Query("time") time: Timestamp): List<Maintain>

    @POST("maintains")
    suspend fun createMaintain(@Body request: Maintain): Int

    @PUT("maintains")
    suspend fun updateMaintain(
        //@Path("id") id: Int,
        @Body updateRequest: Maintain
    ): Maintain?

    @DELETE("maintains")
    suspend fun deleteMaintain(@Query("id") id: Int): Response<Unit>
}

@SuppressLint("NewApi")
object MaintainAipInstance {
    private const val BASE_URL = "http://10.0.2.2:8080/skin-sercet-maven/user/"

    @RequiresApi(Build.VERSION_CODES.O)
    private val gson: Gson = GsonBuilder()
        .setDateFormat("yyyy/MM/dd HH:mm:ss")
        .registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeTypeAdapter())
        .create()

    val api: MaintainApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(MaintainApiService::class.java)
    }
}
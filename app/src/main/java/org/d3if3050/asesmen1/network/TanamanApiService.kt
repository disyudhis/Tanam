package org.d3if3050.asesmen1.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3050.asesmen1.model.Galeri
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://raw.githubusercontent.com/disyudhis/Asesmen1-Mopro/static-api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TanamanApiService {
    @GET("static-api.json")
    suspend fun getTanaman(): List<Galeri>
}

object TanamanApi {
    val service: TanamanApiService by lazy {
        retrofit.create(TanamanApiService::class.java)
    }

    fun getTanamanUrl(imageRes: String): String {
        return "$BASE_URL$imageRes.jpg"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }
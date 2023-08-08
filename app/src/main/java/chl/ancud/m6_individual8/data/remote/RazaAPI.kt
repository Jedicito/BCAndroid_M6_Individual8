package chl.ancud.m6_individual8.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface RazaAPI {

    @GET("breeds/list/all")
    suspend fun getData(): Response<Raza>
}
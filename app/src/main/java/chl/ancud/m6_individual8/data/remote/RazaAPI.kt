package chl.ancud.m6_individual8.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RazaAPI {

    @GET("breeds/list/all")
    suspend fun getData(): Response<Raza>

    @GET("breed/{raza}/images")
    suspend fun getDetalleRaza(@Path("raza") raza: String): Response<RazaDetalle>
}
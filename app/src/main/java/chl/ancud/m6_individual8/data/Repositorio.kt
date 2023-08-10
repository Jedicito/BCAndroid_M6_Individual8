package chl.ancud.m6_individual8.data

import android.util.Log
import androidx.lifecycle.LiveData
import chl.ancud.m6_individual8.data.local.FotosDetalleEntity
import chl.ancud.m6_individual8.data.local.RazaDao
import chl.ancud.m6_individual8.data.local.RazaEntity
import chl.ancud.m6_individual8.data.remote.Raza
import chl.ancud.m6_individual8.data.remote.RazaAPI
import retrofit2.Response

class Repositorio(private val razaAPI: RazaAPI, private val razaDao: RazaDao) {

    suspend fun getRazas() {
        val response = razaAPI.getData() //acá llegan los datos
        if(response.isSuccessful) {  //Llegaron los datos?
            val message = response.body()!!.message //Solo sacando la parte de message, sin status
            val keys = message.keys
            keys.forEach {
                val razaEntity = RazaEntity(it)
                razaDao.insertRaza(razaEntity)
            }
        } else {
            Log.e("Repositorio", response.errorBody().toString())
        }
    }

    suspend fun getDetalleRaza(nombre: String) {
        val response = razaAPI.getDetalleRaza(nombre)
        if (response.isSuccessful){
            val message = response.body()!!.message
            message.forEach {
                val fotosDetalleEntity = FotosDetalleEntity(nombre, it)
                razaDao.insertFotosDetalle(fotosDetalleEntity)
            }
        }else {
            Log.e("Repositorio", response.errorBody().toString())
        }
    }

    fun obtenerRazasLiveData(): LiveData<List<RazaEntity>> = razaDao.getRazas()
}
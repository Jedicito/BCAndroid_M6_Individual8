package chl.ancud.m6_individual8.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import chl.ancud.m6_individual8.data.remote.Raza
import chl.ancud.m6_individual8.data.remote.RazaDetalle

@Dao
interface RazaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRaza(razaEntity: RazaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFotosDetalle(fotosDetalleEntity: FotosDetalleEntity)

    @Query("Select * from tabla_razas order by raza asc")
    fun getRazas(): LiveData<List<RazaEntity>>

    @Query("Select * from tabla_fotosdetalle where nombre like :raza")
    fun getFotosRaza(raza: String): LiveData<List<FotosDetalleEntity>>
}
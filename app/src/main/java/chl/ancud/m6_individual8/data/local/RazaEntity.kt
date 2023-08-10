package chl.ancud.m6_individual8.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_razas")
class RazaEntity (@PrimaryKey val raza: String)

@Entity(tableName = "tabla_fotosdetalle", primaryKeys = ["nombre", "ruta"])
class FotosDetalleEntity(val nombre: String, val ruta: String)

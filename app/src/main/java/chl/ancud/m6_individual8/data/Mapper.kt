package chl.ancud.m6_individual8.data

import chl.ancud.m6_individual8.data.local.FotosDetalleEntity
import chl.ancud.m6_individual8.data.local.RazaEntity

fun String.toEntity(id: String): FotosDetalleEntity = FotosDetalleEntity(id, this)

fun String.toRazaEntity(): RazaEntity = RazaEntity(this)
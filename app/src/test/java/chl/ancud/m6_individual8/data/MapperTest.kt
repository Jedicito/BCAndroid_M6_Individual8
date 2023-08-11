package chl.ancud.m6_individual8.data

import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {
        //given
        val urlImg = "url de la imagen"
        val id = "id"

        //when
        val resultado = urlImg.toEntity(id)

        //then
        assertEquals(id, resultado.nombre)
        assertEquals(urlImg, resultado.ruta)

    }

    @Test
    fun toRazaEntity() {
        //given
        val id = "id"

        //when
        val res = id.toRazaEntity()

        //then
        assertEquals(id, res.raza)
    }
}
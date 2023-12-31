package chl.ancud.m6_individual8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
[] 2 pantallas: Listado y detalle
[X] Permiso de internet
[X] ViewBinding
[X] Dependencias: Coil, Room, Retrofit, navigation, viewModel
[] navigation
[] Listado: RecyclerView + ViewHolder + Adapter
[] Detalle: RecyclerView + ViewHolder + Adapter
[] Repositorio
[] Remoto:
    [] Dataclass
    [] API (interfaz)
    [] Retrofit
[] Local:
    [] Database
    [] Entity
    [] DAO
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
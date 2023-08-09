package chl.ancud.m6_individual8.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import chl.ancud.m6_individual8.data.Repositorio
import chl.ancud.m6_individual8.data.local.RazaDatabase
import chl.ancud.m6_individual8.data.remote.RazaRetrofit
import kotlinx.coroutines.launch

class RazaViewModel (application: Application): AndroidViewModel(application) {
    private val repositorio: Repositorio

    init {
        val api = RazaRetrofit.getRetrofitRaza()
        val razaDatabase = RazaDatabase.getDatabase(application).getRazaDao()
        repositorio = Repositorio(api, razaDatabase)
    }

    fun getAllRazas() = viewModelScope.launch {
        repositorio.getRazas()
    }

    fun razasLiveData() = repositorio.obtenerRazasLiveData()


}

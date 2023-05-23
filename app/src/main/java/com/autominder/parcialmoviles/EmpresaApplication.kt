package com.autominder.parcialmoviles

import android.app.Application
import com.autominder.parcialmoviles.dummyData.dummyEmpresas
import com.autominder.parcialmoviles.repository.EmpresaRepository

class EmpresaApplication() : Application() {
    val empresaRepository: EmpresaRepository by lazy {
        EmpresaRepository()
    }
}
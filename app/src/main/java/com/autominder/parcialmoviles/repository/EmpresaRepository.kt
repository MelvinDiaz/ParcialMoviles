package com.autominder.parcialmoviles.repository

import com.autominder.parcialmoviles.dummyData.dummyEmpresas
import com.autominder.parcialmoviles.model.EmpresaDataModel

class EmpresaRepository() {

    fun getEmpresas() = dummyEmpresas

    fun getEmpresaById(id: Int) = dummyEmpresas.find { it.id == id }

    fun addEmpresa(empresa: EmpresaDataModel) {
        dummyEmpresas.add(empresa)
    }
}
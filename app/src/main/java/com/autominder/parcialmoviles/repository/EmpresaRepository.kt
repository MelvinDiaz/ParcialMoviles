package com.autominder.parcialmoviles.repository

import com.autominder.parcialmoviles.model.EmpresaDataModel

class EmpresaRepository(private val empresaDummy: List<EmpresaDataModel>) {

    fun getEmpresas() = empresaDummy


}
package com.autominder.parcialmoviles.repository

import com.autominder.parcialmoviles.model.EmpresaDataModel

class EmpresaRepository(private val empresaDummy: List<EmpresaDataModel>) {

    fun getEmpresas() = empresaDummy

    fun getEmpresaById(id: Int) = empresaDummy.find { it.id == id }
}
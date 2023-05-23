package com.autominder.parcialmoviles.empresa.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.autominder.parcialmoviles.EmpresaApplication
import com.autominder.parcialmoviles.model.EmpresaDataModel
import com.autominder.parcialmoviles.repository.EmpresaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmpresaViewModel(
    private val repository: EmpresaRepository
) : ViewModel() {
    private val _empresaList = MutableStateFlow<List<EmpresaDataModel>>(emptyList())
    val empresaList: StateFlow<List<EmpresaDataModel>> = _empresaList
    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoding: StateFlow<Boolean> = _isLoading
    private val _name = MutableStateFlow<String>("")
    val name: StateFlow<String> = _name
    private val _sector = MutableStateFlow<String>("")
    val sector: StateFlow<String> = _sector
    private val _id = MutableStateFlow<Int>(0)
    val id: StateFlow<Int> = _id
    private val _newEmpresa = MutableStateFlow<EmpresaDataModel>(EmpresaDataModel(0, "", ""))
    val newEmpresa: StateFlow<EmpresaDataModel> = _newEmpresa
    private val _addEmpresaEnable = MutableStateFlow<Boolean>(false)
    val addEmpresaEnable: StateFlow<Boolean> = _addEmpresaEnable

    init {
        getEmpresas()
    }

    fun onAddEmpresaChange(id: Int, name: String, sector: String) {
        _id.value = id
        _name.value = name
        _sector.value = sector

        _newEmpresa.value = EmpresaDataModel(id, name, sector)
        _addEmpresaEnable.value = validFields(id, name, sector)
    }

    fun validFields(
        id: Int, name: String, sector: String
    ): Boolean = name != "" && id != 0 && sector != ""

    fun addEmpresa(empresa: EmpresaDataModel) {
        repository.addEmpresa(empresa)
    }


    fun getEmpresas() {
        viewModelScope.launch {
            _empresaList.value = repository.getEmpresas()
        }
    }

    fun getEmpresaById(id: Int): EmpresaDataModel? {
        return repository.getEmpresaById(id)
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as EmpresaApplication
                EmpresaViewModel(app.empresaRepository)
            }
        }
    }
}
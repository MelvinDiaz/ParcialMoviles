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

    init {
        getEmpresas()
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
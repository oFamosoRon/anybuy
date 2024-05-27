package com.devira.anybuy.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devira.anybuy.repository.ProductsRepository
import com.devira.anybuy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getAllProducts().collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            products = resource.data ?: emptyList(),
                            isLoadingProducts = false
                        )
                    }

                    else -> {
                        _state.value = _state.value.copy(
                            isLoadingProducts = true
                        )
                    }
                }
            }
        }
    }
}
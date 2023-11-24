package com.dexciuq.rickandmortyapp.presentation.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dexciuq.rickandmortyapp.domain.usecase.GetAllCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MainScreenState>(MainScreenState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getAllCharacters() = viewModelScope.launch {
        val characters = getAllCharactersUseCase(page = 1)
        _uiState.emit(MainScreenState.Success(characters))
    }
}
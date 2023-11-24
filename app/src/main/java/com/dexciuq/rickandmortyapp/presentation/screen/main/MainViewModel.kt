package com.dexciuq.rickandmortyapp.presentation.screen.main

import androidx.lifecycle.ViewModel
import com.dexciuq.rickandmortyapp.domain.model.Character
import com.dexciuq.rickandmortyapp.domain.usecase.GetAllCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _characters = MutableStateFlow(emptyList<Character>())
    val characters = _characters.asStateFlow()

    suspend fun getAllCharacters() {
        _characters.emit(getAllCharactersUseCase(page = 1))
    }
}
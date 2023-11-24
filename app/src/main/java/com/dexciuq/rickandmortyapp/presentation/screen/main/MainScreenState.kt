package com.dexciuq.rickandmortyapp.presentation.screen.main

import com.dexciuq.rickandmortyapp.domain.model.Character

sealed class MainScreenState {
    object Loading : MainScreenState()
    data class Error(val message: String) : MainScreenState()
    data class Success(val characters: List<Character>) : MainScreenState()
}
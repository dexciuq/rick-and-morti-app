package com.dexciuq.rickandmortyapp.domain.usecase

import com.dexciuq.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllCharactersUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        characterRepository.getAllCharacters()
    }
}
package com.dexciuq.rickandmortyapp.domain.usecase

import com.dexciuq.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCharacterUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(id: Int) = withContext(Dispatchers.IO) {
        characterRepository.getCharacter(id)
    }
}
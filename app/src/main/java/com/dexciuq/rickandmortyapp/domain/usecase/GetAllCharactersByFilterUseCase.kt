package com.dexciuq.rickandmortyapp.domain.usecase

import com.dexciuq.rickandmortyapp.domain.model.Filter
import com.dexciuq.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAllCharactersByFilterUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(filter: Filter, page: Int) = withContext(Dispatchers.IO) {
        characterRepository.getAllCharactersByFilter(filter, page)
    }
}
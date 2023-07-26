package com.dexciuq.rickandmortyapp.data.repository

import com.dexciuq.rickandmortyapp.data.source.CharacterDataSource
import com.dexciuq.rickandmortyapp.domain.model.Character
import com.dexciuq.rickandmortyapp.domain.model.Filter
import com.dexciuq.rickandmortyapp.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val characterDataSource: CharacterDataSource
) : CharacterRepository {

    override suspend fun getCharacter(id: Int): Character =
        characterDataSource.getCharacter(id)

    override suspend fun getAllCharacters(): List<Character> =
        characterDataSource.getAllCharacters()

    override suspend fun getAllCharactersByFilter(filter: Filter): List<Character> =
        characterDataSource.getAllCharactersByFilter(filter)
}
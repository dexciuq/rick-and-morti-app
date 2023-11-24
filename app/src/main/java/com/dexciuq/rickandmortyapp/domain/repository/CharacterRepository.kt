package com.dexciuq.rickandmortyapp.domain.repository

import com.dexciuq.rickandmortyapp.domain.model.Character
import com.dexciuq.rickandmortyapp.domain.model.Filter

interface CharacterRepository {
    suspend fun getCharacter(id: Int): Character
    suspend fun getAllCharacters(page: Int): List<Character>
    suspend fun getAllCharactersByFilter(filter: Filter, page: Int): List<Character>
}
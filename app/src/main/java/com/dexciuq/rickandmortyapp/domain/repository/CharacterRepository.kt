package com.dexciuq.rickandmortyapp.domain.repository

import com.dexciuq.rickandmortyapp.domain.model.Character
import com.dexciuq.rickandmortyapp.domain.model.Filter

interface CharacterRepository {
    suspend fun getCharacter(id: Int): Character
    suspend fun getAllCharacters(): List<Character>
    suspend fun getAllCharactersByFilter(filter: Filter): List<Character>
}
package com.dexciuq.rickandmortyapp.data.source.remote

import com.dexciuq.rickandmortyapp.data.mapper.Mapper
import com.dexciuq.rickandmortyapp.data.model.CharacterDto
import com.dexciuq.rickandmortyapp.data.source.CharacterDataSource
import com.dexciuq.rickandmortyapp.domain.model.Character
import com.dexciuq.rickandmortyapp.domain.model.Filter

class RemoteDataSource(
    private val apiService: RickAndMortyApiService,
    private val mapper: Mapper<CharacterDto, Character>,
) : CharacterDataSource {

    override suspend fun getCharacter(id: Int): Character = mapper.transform(
        apiService.getSingleCharacter(id)
    )

    override suspend fun getAllCharacters(page: Int): List<Character> = mapper.transformAll(
        apiService.getAllCharacters(page).results
    )

    override suspend fun getAllCharactersByFilter(filter: Filter, page: Int): List<Character> = mapper.transformAll(
        apiService.getAllCharactersByFilter(
            name = filter.name,
            status = filter.status,
            species = filter.species,
            type = filter.type,
            gender = filter.gender,
            page = page
        ).results
    )
}
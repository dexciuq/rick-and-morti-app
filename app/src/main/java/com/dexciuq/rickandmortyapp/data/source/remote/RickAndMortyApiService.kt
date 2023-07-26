package com.dexciuq.rickandmortyapp.data.source.remote

import com.dexciuq.rickandmortyapp.data.model.CharacterDto
import com.dexciuq.rickandmortyapp.data.model.ResultDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiService {

    @GET("/api/character")
    suspend fun getAllCharacters() : ResultDto

    @GET("/api/character/")
    suspend fun getAllCharactersByFilter(
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("species") species: String?,
        @Query("type") type: String?,
        @Query("gender") gender: String?,
    ) : ResultDto

    @GET("/api/character/{id}")
    suspend fun getSingleCharacter(@Path("id") id: Int) : CharacterDto
}
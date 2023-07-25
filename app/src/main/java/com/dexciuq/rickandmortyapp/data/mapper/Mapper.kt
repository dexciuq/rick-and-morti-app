package com.dexciuq.rickandmortyapp.data.mapper

import com.dexciuq.rickandmortyapp.data.model.CharacterDto
import com.dexciuq.rickandmortyapp.domain.model.Character

fun CharacterDto.toDomain() = Character(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin.name,
    location = location.name,
    image = image,
    episode = episode,
    url = url,
    created = created,
)
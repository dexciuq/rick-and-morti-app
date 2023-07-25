package com.dexciuq.rickandmortyapp.data.mapper

import com.dexciuq.rickandmortyapp.data.model.CharacterDto
import com.dexciuq.rickandmortyapp.domain.model.Character

class CharacterMapper : Mapper<CharacterDto, Character> {

    override fun transform(param: CharacterDto) = Character(
        id = param.id,
        name = param.name,
        status = param.status,
        species = param.species,
        type = param.type,
        gender = param.gender,
        origin = param.origin.name,
        location = param.location.name,
        image = param.image,
        episode =param.episode,
        url = param.url,
        created = param.created,
    )
}
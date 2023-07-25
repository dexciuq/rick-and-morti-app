package com.dexciuq.rickandmortyapp.data.model

import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("info") val info: InfoDto,
    @SerializedName("results") val results: List<CharacterDto>,
)
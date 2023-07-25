package com.dexciuq.rickandmortyapp.data.mapper

interface Mapper<in P, out R> {
    fun transform(param: P): R
    fun transformAll(params: List<P>): List<R> = params.map(::transform)
}
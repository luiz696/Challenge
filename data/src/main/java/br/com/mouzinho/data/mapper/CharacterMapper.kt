package br.com.mouzinho.data.mapper

import br.com.mouzinho.data.entity.ApiMarvelCharacter
import br.com.mouzinho.data.entity.ApiComics
import br.com.mouzinho.data.entity.ApiSeries
import br.com.mouzinho.data.entity.ApiThumbnail
import br.com.mouzinho.domain.entity.character.MarvelCharacter
import br.com.mouzinho.domain.entity.character.Comics
import br.com.mouzinho.domain.entity.character.Series
import br.com.mouzinho.domain.entity.character.Thumbnail
import br.com.mouzinho.domain.mapper.Mapper
import javax.inject.Inject

class CharacterMapper @Inject constructor(
    private val comicsMapper: Mapper<ApiComics, Comics>,
    private val seriesMapper: Mapper<ApiSeries, Series>,
    private val thumbnailMapper: Mapper<ApiThumbnail, Thumbnail>
) : Mapper<ApiMarvelCharacter, MarvelCharacter> {

    override fun transform(input: ApiMarvelCharacter) = MarvelCharacter(
        comics = input.comics?.let(comicsMapper::transform),
        description = input.description,
        id = input.id ?: System.currentTimeMillis().toInt(),
        name = input.name ?: "",
        resourceURI = input.resourceURI ?: "",
        series = input.series?.let(seriesMapper::transform),
        thumbnail = input.thumbnail?.let(thumbnailMapper::transform),
    )
}
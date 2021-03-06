package br.com.mouzinho.data.repository.character

import androidx.paging.DataSource
import br.com.mouzinho.data.database.dao.FavoritesCharactersDao
import br.com.mouzinho.data.entity.ApiMarvelCharacter
import br.com.mouzinho.data.network.ApiService
import br.com.mouzinho.domain.entity.character.MarvelCharacter
import br.com.mouzinho.domain.entity.character.MarvelCharacterPagingResult
import br.com.mouzinho.domain.mapper.Mapper
import io.reactivex.subjects.PublishSubject

class CharacterDataSourceFactory(
    private val apiService: ApiService,
    private val favoritesDao: FavoritesCharactersDao,
    private val mapper: Mapper<ApiMarvelCharacter, MarvelCharacter>,
    private val pagingPublisher: PublishSubject<MarvelCharacterPagingResult>
) : DataSource.Factory<Int, MarvelCharacter>() {
    var query = ""
    private lateinit var dataSource: DataSource<Int, MarvelCharacter>

    fun invalidate() = dataSource.invalidate()

    override fun create(): DataSource<Int, MarvelCharacter> {
        dataSource = if (query.isBlank()) CharacterDataSource(apiService, favoritesDao, mapper, pagingPublisher)
        else CharacterDataSource(apiService, favoritesDao, mapper, pagingPublisher, query)
        return dataSource
    }
}
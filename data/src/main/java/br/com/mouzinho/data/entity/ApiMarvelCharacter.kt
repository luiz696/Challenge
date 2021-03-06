package br.com.mouzinho.data.entity

data class ApiMarvelCharacter(
    val comics: ApiComics?,
    val description: String?,
    val events: ApiEvents?,
    val id: Int?,
    val modified: String?,
    val name: String?,
    val resourceURI: String?,
    val series: ApiSeries?,
    val stories: ApiStories?,
    val thumbnail: ApiThumbnail?,
    val urls: List<ApiUrl>?
)
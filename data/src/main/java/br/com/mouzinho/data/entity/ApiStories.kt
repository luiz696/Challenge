package br.com.mouzinho.data.entity

data class ApiStories(
    val available: Int?,
    val collectionURI: String?,
    val items: List<ApiItem>?,
    val returned: Int?
)
package br.com.mouzinho.domain.entity.character

import java.io.Serializable

data class Comics(
    val available: Int?,
    val collectionURI: String?,
    val items: List<Item>?,
    val returned: Int?
) : Serializable
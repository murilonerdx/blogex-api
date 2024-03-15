package org.murilonerdx.blogex.domain.dtos.response

import org.murilonerdx.blogex.infra.model.entity.Category
import org.murilonerdx.blogex.infra.model.entity.Content
import org.springframework.data.annotation.Id

data class PostResponse(
    val id: String?,
    val name: String?,
    val description: String?,
    val category: Category?,
    val content: Content?,
    val user: String?
)

package org.murilonerdx.blogex.infra.model.entity

import org.murilonerdx.blogex.domain.dtos.response.PostResponse
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Post(
    @Id
    val id: String?,
    val name: String?,
    val description: String?,
    val category: Category?,
    val content: Content?,
    val user: String?
){
    fun toResponse(): PostResponse {
        return PostResponse(
            id = null,
            name = this.name,
            description = this.description,
            category = this.category,
            content = this.content,
            user = user
        )
    }
}

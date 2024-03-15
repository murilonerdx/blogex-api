package org.murilonerdx.blogex.domain.dtos.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.murilonerdx.blogex.infra.model.entity.Category
import org.murilonerdx.blogex.infra.model.entity.Content
import org.murilonerdx.blogex.infra.model.entity.Post

data class PostRequest(
    @NotEmpty(message= "Name is empty")
    val name: String,
    @Size(min = 10, message = "Please description length min is 10 character")
    @NotEmpty(message= "Description is empty")
    val description: String,
    @NotNull(message= "Please set one category")
    val category: Category,
    val content: Content
){
    fun toModel(user: String): Post {
        return Post(
            id = null,
            name = this.name,
            description = this.description,
            category = this.category,
            content = this.content,
            user = user
        )
    }
}

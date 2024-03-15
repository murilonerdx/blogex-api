package org.murilonerdx.blogex.infra.model.entity

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class Content(
    @Size(min = 10, message = "Please title length min is 10 character")
    @NotEmpty(message= "Title required not empty")
    val title: String,
    @Size(min = 10, message = "Please content length min is 10 character")
    @NotEmpty(message= "Content required not empty")
    val content: String,
)

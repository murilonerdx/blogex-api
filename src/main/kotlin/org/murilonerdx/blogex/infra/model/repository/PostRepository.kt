package org.murilonerdx.blogex.infra.model.repository

import org.murilonerdx.blogex.infra.model.entity.Category
import org.murilonerdx.blogex.infra.model.entity.Post
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository : MongoRepository<Post, String> {
    fun findPostByName(name: String): Post
    fun findByUser(nameOwner: String): Post
    fun findPostByCategory(category: Category): Post
}
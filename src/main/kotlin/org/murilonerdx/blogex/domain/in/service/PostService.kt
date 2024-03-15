package org.murilonerdx.blogex.domain.`in`.service

import org.murilonerdx.blogex.domain.dtos.request.PostRequest
import org.murilonerdx.blogex.infra.model.entity.Category
import org.murilonerdx.blogex.infra.model.entity.Post

interface PostService {
    fun findById(id: String): Post
    fun findAllPost(): MutableList<Post>
    fun createPost(post: PostRequest, owner: String?): Post
    fun deletePost(id: String, owner: String?)
    fun updatePost(id: String, owner: String?, post: PostRequest)
    fun findPostByName(name: String): Post
    fun findPostByUserOwner(nameOwner: String): Post
    fun findPostByCategory(category: Category): Post
}
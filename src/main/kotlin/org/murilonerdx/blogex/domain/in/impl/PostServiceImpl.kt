package org.murilonerdx.blogex.domain.`in`.impl

import org.murilonerdx.blogex.application.exception.LoginInvalidException
import org.murilonerdx.blogex.application.exception.NotFoundIdException
import org.murilonerdx.blogex.application.exception.NotPermission
import org.murilonerdx.blogex.domain.dtos.request.PostRequest
import org.murilonerdx.blogex.domain.`in`.service.PostService
import org.murilonerdx.blogex.infra.model.entity.Category
import org.murilonerdx.blogex.infra.model.entity.Post
import org.murilonerdx.blogex.infra.model.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(val postRepository: PostRepository) : PostService {
    override fun findById(id: String): Post {
        return postRepository.findById(id).orElseThrow { NotFoundIdException(id) };
    }

    override fun findAllPost(): MutableList<Post> {
        return postRepository.findAll()
    }

    fun verifyOwner(owner: String?) {
        if (owner != null) {
            return;
        } else {
            throw LoginInvalidException()
        }
    }

    override fun createPost(post: PostRequest, owner: String?): Post {
        verifyOwner(owner)
        return postRepository.save(post.toModel(owner!!));
    }

    override fun deletePost(id: String, owner: String?) {
        verifyOwner(owner)
        val modelFindById = findById(id)
        if (modelFindById.user.equals(owner)) {
            postRepository.delete(modelFindById);
        } else {
            throw NotPermission(id)
        }
    }

    override fun updatePost(id: String, owner: String?, post: PostRequest) {
        verifyOwner(owner)
        val modelFindById = findById(id)
        if (modelFindById.user.equals(owner)) {
            val updatePost = modelFindById.copy(
                name = post.name,
                description = post.description,
                category = post.category,
                content = post.content
            )
            postRepository.save(updatePost);
        }
    }

    override fun findPostByName(name: String): Post {
        return postRepository.findPostByName(name)
    }

    override fun findPostByUserOwner(nameOwner: String): Post {
        return postRepository.findByUser(nameOwner)
    }

    override fun findPostByCategory(category: Category): Post {
        return postRepository.findPostByCategory(category)
    }

}
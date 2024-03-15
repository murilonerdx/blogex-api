package org.murilonerdx.blogex.application.controller

import org.murilonerdx.blogex.domain.dtos.request.PostRequest
import org.murilonerdx.blogex.domain.`in`.service.PostService
import org.murilonerdx.blogex.infra.model.entity.Category
import org.murilonerdx.blogex.infra.model.entity.Post
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/post")
class PostController(val postService: PostService) {

    @GetMapping()
    fun findAll(@AuthenticationPrincipal principal: OAuth2User): MutableList<Post> {
        return postService.findAllPost()
    }

    @PostMapping
    fun createPost(@AuthenticationPrincipal principal: OAuth2User, @RequestBody post: PostRequest): Post {
        return postService.createPost(post, principal.getAttribute("email"))
    }

    @GetMapping("find-by-id/{id}")
    fun findById(@PathVariable id: String): Post {
        return postService.findById(id)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@AuthenticationPrincipal principal: OAuth2User, @PathVariable id: String) {
        return postService.deletePost(id, principal.getAttribute("email"))
    }

    @PutMapping("/{id}")
    fun updatePost(@AuthenticationPrincipal principal: OAuth2User,
                   @PathVariable id: String, @RequestBody post: PostRequest) {
        return postService.updatePost(id, principal.getAttribute("email"), post)
    }

    @GetMapping("find-by-post-name")
    fun findPostByName(@RequestParam name: String): Post {
        return postService.findPostByName(name)
    }

    @GetMapping("find-by-post-user")
    fun findPostByUserOwner(@RequestParam nameOwner: String): Post {
        return postService.findPostByUserOwner(nameOwner)
    }

    @GetMapping("find-by-post-category")
    fun findPostByCategory(@RequestParam category: Category): Post {
        return postService.findPostByCategory(category)
    }

}
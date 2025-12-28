package io.micrologs.article.post.controller;

import io.micrologs.article.post.dto.PostCreationRequestDTO;
import io.micrologs.article.post.dto.PostCreationResponseDTO;
import io.micrologs.article.post.entity.Post;
import io.micrologs.article.post.services.PostService;
import io.micrologs.article.util.ResponseHandler;
import io.micrologs.article.util.exception.UserDisplayException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class PostController
{
    private final PostService postService;

    @PostMapping
    @SneakyThrows
    public ResponseEntity<Object> createPost(
            HttpServletRequest request,
            @RequestHeader("X-Username") String username,
            @Valid @RequestBody PostCreationRequestDTO postCreationRequest)
    {
        if (username == null || username.isBlank()) {
            throw new UserDisplayException("Missing user context" , HttpStatus.UNAUTHORIZED);
        }

        String slug = postService.addPost(username, postCreationRequest);

        return ResponseHandler.generateResponse(
                "Post created successfully",
                HttpStatus.CREATED,
                PostCreationResponseDTO.builder().slug(slug).build()
        );
    }


    @GetMapping("/{slug}")
    @SneakyThrows
    public ResponseEntity<Object> getPost(HttpServletRequest request , @PathVariable("slug") String slug)
    {
        return ResponseHandler.generateResponse("post retrieve" , HttpStatus.OK ,  postService.getPost(slug));
    }

    @GetMapping("/by-user/{username}")
    @SneakyThrows
    public ResponseEntity<Object> getArticlesByUsername(
            @PathVariable String username) {

        List<Post> posts = postService.getArticlesByUsername(username);
        return ResponseHandler.generateResponse("User posts", HttpStatus.OK, posts);
    }
}

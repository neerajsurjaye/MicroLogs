package io.micrologs.article.post.controller;

import io.micrologs.article.post.dto.PostCreationRequestDTO;
import io.micrologs.article.post.dto.PostCreationResponseDTO;
import io.micrologs.article.post.services.PostService;
import io.micrologs.article.util.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class PostController
{
    @Autowired
    PostService postService;

    @PostMapping
    @SneakyThrows
    public ResponseEntity<Object> createPost(HttpServletRequest request, @Valid @RequestBody PostCreationRequestDTO postCreationRequest)
    {

        String username = "aman";
        String slug = postService.addPost(username, postCreationRequest);
        return ResponseHandler.generateResponse("Post created successfully", HttpStatus.CREATED, PostCreationResponseDTO.builder().slug(slug).build());
    }

    @GetMapping("/{slug}")
    @SneakyThrows
    public ResponseEntity<Object> getPost(HttpServletRequest request , @PathVariable("slug") String slug)
    {
        return ResponseHandler.generateResponse("post retrieve" , HttpStatus.OK ,  postService.getPost(slug));
    }
}

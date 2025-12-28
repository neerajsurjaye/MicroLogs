package io.micrologs.article.post.controller;

import io.micrologs.article.post.services.PostLikeService;
import io.micrologs.article.util.ResponseHandler;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class PostLikeController
{
    private final PostLikeService postLikeService;

    @PostMapping("/{postId}/like")
    @SneakyThrows
    public ResponseEntity<Object> likePost(
            @RequestHeader("X-Username") String username,
            @PathVariable int postId)
    {

        postLikeService.likePost(username, postId);

        return ResponseHandler.generateResponse(
                "Post liked successfully",
                HttpStatus.OK,
                null
        );
    }

    @DeleteMapping("/{postId}/like")
    @SneakyThrows
    public ResponseEntity<Object> unlikePost(
            @RequestHeader("X-Username") String username,
            @PathVariable int postId)
    {

        postLikeService.unlikePost(username, postId);

        return ResponseHandler.generateResponse(
                "Post unliked successfully",
                HttpStatus.OK,
                null
        );
    }
}


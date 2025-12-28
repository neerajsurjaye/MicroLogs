package io.micrologs.article.comment.controller;

import io.micrologs.article.comment.entity.Comment;
import io.micrologs.article.comment.service.CommentService;
import io.micrologs.article.util.ResponseHandler;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // CREATE COMMENT
    @PostMapping("/{postId}")
    @SneakyThrows
    public ResponseEntity<Object> addComment(
            @PathVariable int postId,
            @RequestHeader("X-Username") String username,
            @RequestBody Map<String, String> body) {

        Comment comment = commentService.addComment(
                username,
                postId,
                body.get("commentContent")
        );

        return ResponseHandler.generateResponse(
                "Comment added successfully",
                HttpStatus.CREATED,
                comment
        );
    }

    // GET COMMENTS BY POST
    @GetMapping("/post/{postId}")
    public ResponseEntity<Object> getCommentsByPost(@PathVariable int postId) {

        return ResponseHandler.generateResponse(
                "Post comments",
                HttpStatus.OK,
                commentService.getCommentsByPost(postId)
        );
    }

    // GET COMMENTS BY USER
    @GetMapping("/by-user/{username}")
    @SneakyThrows
    public ResponseEntity<Object> getCommentsByUser(@PathVariable String username) {

        return ResponseHandler.generateResponse(
                "User comments",
                HttpStatus.OK,
                commentService.getCommentsByUser(username)
        );
    }
}

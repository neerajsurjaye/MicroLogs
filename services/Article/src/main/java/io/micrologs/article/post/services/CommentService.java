package io.micrologs.article.post.services;

import io.micrologs.article.post.dto.CommentCreationRequestDTO;
import io.micrologs.article.post.entity.Comment;

import java.util.List;

public interface CommentService
{
    int addComment(String name , CommentCreationRequestDTO commentCreationRequestDTO);

    List<Comment> getComments(int postId);
}

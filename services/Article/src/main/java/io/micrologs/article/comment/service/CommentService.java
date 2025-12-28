package io.micrologs.article.comment.service;

import io.micrologs.article.post.dto.CommentCreationRequestDTO;
import io.micrologs.article.comment.entity.Comment;
import io.micrologs.article.util.exception.UserDisplayException;

import java.util.List;

public interface CommentService {

    Comment addComment(String username, int postId, String commentContent) throws UserDisplayException;

    List<Comment> getCommentsByPost(int postId);

    List<Comment> getCommentsByUser(String username) throws UserDisplayException;
}

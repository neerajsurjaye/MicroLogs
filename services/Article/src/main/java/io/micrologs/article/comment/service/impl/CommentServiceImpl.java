package io.micrologs.article.comment.service.impl;


import io.micrologs.article.comment.entity.Comment;
import io.micrologs.article.comment.repository.CommentRepository;
import io.micrologs.article.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService
{

    private final   CommentRepository commentRepository;

    @Override
    public Comment addComment(String username, int postId, String commentContent) {

        int authorId = resolveAuthorId(username);

        Comment comment = Comment.builder()
                                 .commentContent(commentContent)
                                 .postId(postId)
                                 .authorId(authorId)
                                 .build();

        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPost(int postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public List<Comment> getCommentsByUser(String username) {
        int authorId = resolveAuthorId(username);
        return commentRepository.findByAuthorId(authorId);
    }

    // 🔴 Temporary hardcoded mapping
    private int resolveAuthorId(String username) {
        return 1;
    }
}


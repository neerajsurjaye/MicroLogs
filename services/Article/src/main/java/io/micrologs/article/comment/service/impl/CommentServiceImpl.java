package io.micrologs.article.comment.service.impl;


import io.micrologs.article.api.UserApi;
import io.micrologs.article.comment.entity.Comment;
import io.micrologs.article.comment.repository.CommentRepository;
import io.micrologs.article.comment.service.CommentService;
import io.micrologs.article.util.CommonService;
import io.micrologs.article.util.exception.UserDisplayException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService
{

    private final CommonService commonService;
    private final   CommentRepository commentRepository;

    @Override
    public Comment addComment(String username, int postId, String commentContent) throws UserDisplayException
    {

        int authorId = commonService.resolveAuthorId(username);

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
    public List<Comment> getCommentsByUser(String username) throws UserDisplayException
    {
        int authorId = commonService.resolveAuthorId(username);
        return commentRepository.findByAuthorId(authorId);
    }
}


package io.micrologs.article.post.services;

import io.micrologs.article.post.dto.PostCreationRequestDTO;
import io.micrologs.article.post.entity.Post;
import io.micrologs.article.util.exception.UserDisplayException;

public interface PostService
{
    String addPost(String username, PostCreationRequestDTO postCreationRequestDTO);

    Post getPost(String slug) throws UserDisplayException;

    void deletePost(String username, Integer articleId) throws UserDisplayException;
}

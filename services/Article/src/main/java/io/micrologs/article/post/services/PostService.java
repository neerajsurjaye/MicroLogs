package io.micrologs.article.post.services;

import io.micrologs.article.post.dto.PostCreationRequestDTO;
import io.micrologs.article.post.entity.Post;
import io.micrologs.article.util.exception.UserDisplayException;

import java.util.List;

public interface PostService {
    String addPost(String username, PostCreationRequestDTO postCreationRequestDTO) throws UserDisplayException;

    Post getPost(String slug) throws UserDisplayException;

    void deletePost(String username, Integer articleId) throws UserDisplayException;

    List<Post> getArticlesByUsername(String username) throws UserDisplayException;

    List<Post> getRecentPost();
}

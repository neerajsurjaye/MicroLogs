package io.micrologs.article.post.services;

import io.micrologs.article.util.exception.UserDisplayException;

public interface PostLikeService {

    void likePost(String username, int postId) throws UserDisplayException;

    void unlikePost(String username, int postId) throws UserDisplayException;
}

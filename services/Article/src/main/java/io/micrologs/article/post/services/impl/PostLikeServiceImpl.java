package io.micrologs.article.post.services.impl;

import io.micrologs.article.api.UserApi;
import io.micrologs.article.post.entity.PostLike;
import io.micrologs.article.post.repository.PostLikeRepository;
import io.micrologs.article.post.repository.PostRepository;
import io.micrologs.article.post.services.PostLikeService;
import io.micrologs.article.util.CommonService;
import io.micrologs.article.util.exception.UserDisplayException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostLikeServiceImpl implements PostLikeService
{

    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final CommonService commonService;

    @Override
    public void likePost(String username, int postId) throws UserDisplayException
    {
        int userId = commonService.resolveAuthorId(username);

        if (postLikeRepository.existsByPostIdAndUserId(postId, userId)) {
            throw new UserDisplayException("Post already liked" , HttpStatus.BAD_REQUEST);
        }

        PostLike like = PostLike.builder()
                                .postId(postId)
                                .userId(userId)
                                .build();

        postLikeRepository.save(like);
        postRepository.incrementLikeCount(postId);
    }

    @Override
    public void unlikePost(String username, int postId) throws UserDisplayException
    {

        int userId = commonService.resolveAuthorId(username);

        PostLike like = postLikeRepository
                .findByPostIdAndUserId(postId, userId)
                .orElseThrow(() -> new UserDisplayException("Post not liked yet" , HttpStatus.BAD_REQUEST));

        postLikeRepository.delete(like);
        postRepository.decrementLikeCount(postId);
    }
}


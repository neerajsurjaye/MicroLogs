package io.micrologs.article.post.services.impl;

import com.github.slugify.Slugify;
import io.micrologs.article.post.dto.PostCreationRequestDTO;
import io.micrologs.article.post.entity.Post;
import io.micrologs.article.post.repository.PostRepository;
import io.micrologs.article.post.services.PostService;
import io.micrologs.article.util.Helper;
import io.micrologs.article.util.exception.UserDisplayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService
{
    @Autowired
    PostRepository postRepository;

    @Override
    public String addPost(String username, PostCreationRequestDTO postCreationRequestDTO)
    {
//        Long userId = userService.findByUsername(username).orElseThrow(() -> new UserDisplayException("no user found", HttpStatus.NOT_FOUND));
        int userId = 1;
        final Slugify slg = Slugify.builder().build();
        String result = slg.slugify(postCreationRequestDTO.getPost().getTitle());
        String randomHash = Helper.generatingRandomAlphanumericString();
        result = result + "-" + randomHash;

        Post newPost = Post.builder().body(postCreationRequestDTO.getPost().getBody()).slug(result).title(postCreationRequestDTO.getPost().getTitle()).description(postCreationRequestDTO.getPost().getDescription()).authorId(userId).build();

        Post returnPost = postRepository.save(newPost);

        return  returnPost.getSlug();
    }

    @Override
    public Post getPost(String slug) throws UserDisplayException
    {
        return  postRepository.findPostDetailsBySlug(slug).orElseThrow(() -> new UserDisplayException("no post found", HttpStatus.NOT_FOUND));
    }

    @Override
    public void deletePost(String username, Integer articleId) throws UserDisplayException
    {
//        UserId user = userRepository.findByUsername(username,UserId.class).orElseThrow(() -> new UserDisplayException("no user found", HttpStatus.NOT_FOUND));

        int userId = 1;
        Post post = postRepository.findById(articleId).orElseThrow(() -> new UserDisplayException("no resource found", HttpStatus.NOT_FOUND));

        //    check ownership of the post
        if (post.getAuthorId() != userId) {
            throw new UserDisplayException("unauthorized", HttpStatus.UNAUTHORIZED);
        }

        postRepository.deleteById(articleId);
    }
}

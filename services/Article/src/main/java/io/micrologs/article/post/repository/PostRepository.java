package io.micrologs.article.post.repository;

import io.micrologs.article.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>
{
    Optional<Post> findPostDetailsBySlug(String slug);
}

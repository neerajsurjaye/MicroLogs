package io.micrologs.article.post.repository;

import io.micrologs.article.post.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Integer>
{

    boolean existsByPostIdAndUserId(int postId, int userId);

    Optional<PostLike> findByPostIdAndUserId(int postId, int userId);

    long countByPostId(int postId);
}


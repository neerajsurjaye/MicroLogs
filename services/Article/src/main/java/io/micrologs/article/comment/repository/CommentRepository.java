package io.micrologs.article.comment.repository;

import io.micrologs.article.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByPostId(int postId);

    List<Comment> findByAuthorId(int authorId);
}


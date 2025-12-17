package io.micrologs.article.post.repository;

import io.micrologs.article.post.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment , Integer>
{

}

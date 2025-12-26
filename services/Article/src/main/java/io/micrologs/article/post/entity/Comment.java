package io.micrologs.article.post.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Comment extends TimeBaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "author_id")
    private int authorId;
}

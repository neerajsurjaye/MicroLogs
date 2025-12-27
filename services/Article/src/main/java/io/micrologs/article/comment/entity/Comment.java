package io.micrologs.article.comment.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micrologs.article.util.TimeBaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_ABSENT)
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

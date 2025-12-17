package io.micrologs.article.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.Instant;

@MappedSuperclass
@Data
public abstract class TimeBaseEntity {


    @Column(name = "created_at",nullable = false , updatable = false ,insertable = false , columnDefinition = "timestamp")
    private Instant createdAt;

    @Column(name = "updated_at" , columnDefinition = "timestamp" , insertable = false)
    private Instant updatedAt;
}


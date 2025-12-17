package io.micrologs.article.post.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostCreationRequestDTO
{
    @NotNull
    @Valid
    private PostDTO post;


    @Getter
    @Setter
    @AllArgsConstructor
    @Builder
    public static class PostDTO {

        @NotBlank(message = "title is required")
        private String title;
        @NotBlank(message = "description is required")
        private String description;
        @NotBlank(message = "body is required")
        private String body;
        @NotEmpty(message = "tags should not be empty")
        private List<String> tagList;
    }
}

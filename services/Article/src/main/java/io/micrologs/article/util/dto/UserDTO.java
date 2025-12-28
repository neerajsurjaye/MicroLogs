package io.micrologs.article.util.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String username;
    private String bio;
    private String profileImageUrl;
}

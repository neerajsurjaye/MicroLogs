package io.micrologs.article.util.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO<T> {
    String message;
    Boolean status;
    T data;

}
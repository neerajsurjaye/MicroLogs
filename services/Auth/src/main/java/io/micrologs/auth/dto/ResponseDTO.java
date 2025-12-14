package io.micrologs.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO<T> {
    String message;
    Boolean status;
    T data;

}

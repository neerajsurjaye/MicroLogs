package io.micrologs.article.util;

import io.micrologs.article.api.UserApi;
import io.micrologs.article.util.dto.ResponseDTO;
import io.micrologs.article.util.dto.UserResponse;
import io.micrologs.article.util.exception.UserDisplayException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonService
{
    private final UserApi userApi;

    public int resolveAuthorId(String username) throws UserDisplayException
    {
        ResponseDTO<UserResponse> userDTO = userApi.getUserByUsername(username);
        if(userDTO.getData() != null) return userDTO.getData().getUserid();
        throw new UserDisplayException("User not found for the given username", HttpStatus.NOT_FOUND);
    }
}

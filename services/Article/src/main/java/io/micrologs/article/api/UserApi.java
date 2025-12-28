package io.micrologs.article.api;


import io.micrologs.article.util.dto.ResponseDTO;
import io.micrologs.article.util.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auth")
public interface UserApi
{
    @GetMapping("/api/v1/user/user/{username}")
    ResponseDTO<UserResponse> getUserByUsername(
            @PathVariable("username") String username
    );
}

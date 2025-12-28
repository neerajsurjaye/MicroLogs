package io.micrologs.article.config;

import feign.Response;
import feign.codec.ErrorDecoder;
import io.micrologs.article.util.exception.UserDisplayException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserFeignErrorDecoder implements ErrorDecoder
{

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.status() == 404) {
            return new UserDisplayException("User not found" , HttpStatus.BAD_GATEWAY);
        }

        if (response.status() == 401 || response.status() == 403) {
            return new UserDisplayException("Unauthorized" , HttpStatus.BAD_GATEWAY);
        }

        return new UserDisplayException("Something went wrong" , HttpStatus.BAD_GATEWAY);
    }
}

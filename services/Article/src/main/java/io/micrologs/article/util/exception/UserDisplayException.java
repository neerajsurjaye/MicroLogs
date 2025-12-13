package io.micrologs.article.util.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class UserDisplayException extends Exception
{
    String message;
    HttpStatus status;

    public UserDisplayException(String s , HttpStatus status)
    {
        super(s);
        this.status = status;
        this.message = s;
    }

    public UserDisplayException(String s ,HttpStatus status , Throwable cause)
    {
        super(s , cause);
        this.status = status;
        this.message = s;
    }
}
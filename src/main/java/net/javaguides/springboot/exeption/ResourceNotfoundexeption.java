package net.javaguides.springboot.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotfoundexeption extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ResourceNotfoundexeption (String message) {
        super(message);}
}

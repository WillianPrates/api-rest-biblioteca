package com.willian.biblioteca.exception;

public class AutorNotFound extends Exception{
    public AutorNotFound() {
    }

    public AutorNotFound(String message) {
        super(message);
    }

    public AutorNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public AutorNotFound(Throwable cause) {
        super(cause);
    }

    public AutorNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

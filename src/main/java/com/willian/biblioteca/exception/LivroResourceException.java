package com.willian.biblioteca.exception;

public class LivroResourceException extends Exception{
    public LivroResourceException() {
    }

    public LivroResourceException(String message) {
        super(message);
    }

    public LivroResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public LivroResourceException(Throwable cause) {
        super(cause);
    }

    public LivroResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

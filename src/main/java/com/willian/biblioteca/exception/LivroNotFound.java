package com.willian.biblioteca.exception;

public class LivroNotFound extends Exception{
    public LivroNotFound() {
    }

    public LivroNotFound(String message) {
        super(message);
    }

    public LivroNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public LivroNotFound(Throwable cause) {
        super(cause);
    }

    public LivroNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

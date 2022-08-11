package com.willian.biblioteca.exception;

public class AutorResourceException extends Exception{
    public AutorResourceException() {
    }

    public AutorResourceException(String message) {
        super(message);
    }

    public AutorResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AutorResourceException(Throwable cause) {
        super(cause);
    }

    public AutorResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

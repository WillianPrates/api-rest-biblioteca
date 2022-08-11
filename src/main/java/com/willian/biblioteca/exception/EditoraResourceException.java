package com.willian.biblioteca.exception;

public class EditoraResourceException extends Exception{
    public EditoraResourceException() {
    }

    public EditoraResourceException(String message) {
        super(message);
    }

    public EditoraResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EditoraResourceException(Throwable cause) {
        super(cause);
    }

    public EditoraResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

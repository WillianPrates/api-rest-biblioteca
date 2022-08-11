package com.willian.biblioteca.exception;

public class EditoraNotFound extends Exception{

    public EditoraNotFound() {
    }

    public EditoraNotFound(String message) {
        super(message);
    }

    public EditoraNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public EditoraNotFound(Throwable cause) {
        super(cause);
    }

    public EditoraNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

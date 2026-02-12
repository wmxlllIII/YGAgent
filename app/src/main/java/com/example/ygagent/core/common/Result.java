package com.example.ygagent.core.common;

public class Result<T> {

    private final T data;
    private final String error;

    private Result(T data, String error) {
        this.data = data;
        this.error = error;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(data, null);
    }

    public static <T> Result<T> error(String error) {
        return new Result<>(null, error);
    }

    public boolean isSuccess() {
        return data != null;
    }

    public T getData() { return data; }
    public String getError() { return error; }
}


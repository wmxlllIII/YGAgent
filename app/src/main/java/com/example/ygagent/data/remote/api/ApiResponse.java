package com.example.ygagent.data.remote.api;

public class ApiResponse<T> {

    private int code;
    private String msg;
    private T data;

    public int getCode() { return code; }
    public String getMsg() { return msg; }
    public T getData() { return data; }

    public boolean isSuccess() {
        return code == 0;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

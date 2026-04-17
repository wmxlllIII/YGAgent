package com.example.ygagent.presentation.controller;

public interface DataCallback<T> {
    void onSuccess(T data);
    void onError(String error);
}
package com.example.ygagent.presentation.controller;

import android.os.Handler;
import android.os.Looper;

import com.example.ygagent.common.constants.LoginType;

public class UserController {

    public static final String TAG = "YG_UserController";
    private final Handler mHandler = new Handler(Looper.getMainLooper());


    public void login(LoginType loginType, String account, String password, DataCallback<UserController> callback) {

    }
}

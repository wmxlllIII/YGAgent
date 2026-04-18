package com.example.ygagent.presentation.controller;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.ygagent.common.constants.LoginType;
import com.example.ygagent.common.utils.WorkerThread;
import com.example.ygagent.core.common.Result;
import com.example.ygagent.data.repository.UserRepositoryImpl;
import com.example.ygagent.domain.entity.User;
import com.example.ygagent.domain.repository.UserRepository;

public class LoginController {

    public static final String TAG = "YG_LoginController";

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private final UserRepository repository = new UserRepositoryImpl();

    public void login(LoginType loginType, String account, String password, DataCallback<User> callback) {
        WorkerThread.getInstance().execute(() -> {

            if (account == null || account.isEmpty()) {
                mHandler.post(() -> {
                    Log.d(TAG, "[x] login #34");
                    callback.onError("账号不能为空");
                });
                return;
            }

            Result<User> result = repository.login(loginType, account, password);
            Log.d(TAG, "[test] login result #41" + result);
            if (result.isSuccess()) {
                callback.onSuccess(result.getData());
            } else {
                callback.onError(result.getError());
            }

        });
    }
}

package com.example.ygagent.presentation.ui.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.ygagent.R;
import com.example.ygagent.common.constants.LoginType;
import com.example.ygagent.databinding.ActivityLoginBinding;
import com.example.ygagent.domain.entity.User;
import com.example.ygagent.presentation.controller.LoginController;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    private static final String TAG = "YG_LoginActivity";

    private LoginController mLoginController;
    private final LoginController.Callback mLoginCallback = new LoginCallback();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mBinding.tvLogin.setOnClickListener(v -> {
            Log.d(TAG, "[test] initView  #32");
            mLoginController.login(
                    LoginType.PASSWORD,
                    mBinding.etAccount.getText().toString(),
                    mBinding.etPassword.getText().toString(),
                    mLoginCallback
            );
        });
    }

    @Override
    protected void initData() {
        mLoginController = new LoginController();
    }

    private class LoginCallback implements LoginController.Callback {

        @Override
        public void onSuccess(User user) {

        }

        @Override
        public void onError(String msg) {

        }
    }
}
package com.example.ygagent.presentation.controller;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.example.ygagent.common.utils.WorkerThread;
import com.example.ygagent.core.common.Result;
import com.example.ygagent.data.repository.SchoolRepositoryImpl;
import com.example.ygagent.domain.entity.School;

import java.util.Collections;
import java.util.List;

public class SchoolController {

    public static final String TAG = "YG_SchoolController";
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final SchoolRepositoryImpl mSchoolRepository = new SchoolRepositoryImpl();

    public void searchSchool(String keyword, DataCallback<List<School>> callback) {
        WorkerThread.getInstance().execute(() -> {
            if (TextUtils.isEmpty(keyword)) {
                mHandler.post(() -> callback.onSuccess(Collections.emptyList()));
                return;
            }

            Result<List<School>> result = mSchoolRepository.search(keyword);
            mHandler.post(() -> {
                if (result.isSuccess()) {
                    callback.onSuccess(result.getData());
                } else {
                    callback.onError(result.getError());
                }
            });

        });
    }
}

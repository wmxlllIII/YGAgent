package com.example.ygagent.presentation.controller;

import com.example.ygagent.domain.entity.School;
import com.example.ygagent.domain.usecase.SearchSchoolUseCase;

import java.util.List;

public class SchoolController {

    public static final String TAG = "YG_SchoolController";
    private final SearchSchoolUseCase searchSchoolUseCase = new SearchSchoolUseCase();


    public interface Callback {
        void onResult(List<School> list);
        void onError(String msg);
    }
    public void searchSchool(String keyword, Callback callback) {
        new Thread(() -> {
            try {
                List<School> result = searchSchoolUseCase.execute(keyword).getData();
                callback.onResult(result);
            } catch (Exception e) {
                callback.onError(e.getMessage());
            }
        }).start();
    }
}

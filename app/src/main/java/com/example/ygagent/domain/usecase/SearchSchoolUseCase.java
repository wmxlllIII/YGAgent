package com.example.ygagent.domain.usecase;

import com.example.ygagent.core.common.Result;
import com.example.ygagent.data.repository.SchoolRepositoryImpl;
import com.example.ygagent.domain.entity.School;
import com.example.ygagent.domain.repository.SchoolRepository;

import java.util.List;

public class SearchSchoolUseCase {

    public static final String TAG = "YG_SearchSchoolUseCase";
    private final SchoolRepository repository = new SchoolRepositoryImpl();

    public Result<List<School>> execute(String keyword) {
        repository.refreshIfNeeded();
        return repository.search(keyword);
    }
}

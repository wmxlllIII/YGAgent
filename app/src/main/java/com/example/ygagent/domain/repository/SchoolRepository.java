package com.example.ygagent.domain.repository;

import com.example.ygagent.core.common.Result;
import com.example.ygagent.domain.entity.School;

import java.util.List;

public interface SchoolRepository {

    Result<List<School>> search(String keyword);

    void refreshIfNeeded();
}


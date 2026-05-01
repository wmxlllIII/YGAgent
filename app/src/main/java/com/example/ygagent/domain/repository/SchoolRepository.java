package com.example.ygagent.domain.repository;

import com.example.ygagent.core.common.Result;
import com.example.ygagent.data.remote.vo.SchoolVO;

import java.util.List;

public interface SchoolRepository {

    Result<List<SchoolVO>> search(String keyword);

    void refreshIfNeeded();
}


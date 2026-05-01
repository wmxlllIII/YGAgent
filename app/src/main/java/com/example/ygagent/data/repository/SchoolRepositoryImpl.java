package com.example.ygagent.data.repository;

import android.util.Log;

import com.example.ygagent.core.common.Result;
import com.example.ygagent.core.network.NetFactory;
import com.example.ygagent.core.network.RetrofitFactory;
import com.example.ygagent.data.mapper.SchoolMapper;
import com.example.ygagent.data.remote.api.SchoolApi;
import com.example.ygagent.data.remote.dto.req.SearchSchoolReqDto;
import com.example.ygagent.data.remote.dto.req.UpdateSchoolReqDto;
import com.example.ygagent.data.remote.dto.resp.SearchSchoolRespDto;
import com.example.ygagent.data.remote.vo.SchoolVO;
import com.example.ygagent.domain.repository.SchoolRepository;

import java.util.ArrayList;
import java.util.List;



public class SchoolRepositoryImpl implements SchoolRepository {


    public static final String TAG = "YG_SchoolRepositoryImpl";
    private final SchoolApi schoolApi = RetrofitFactory.get().create(SchoolApi.class);
    private final SchoolMapper mapper = new SchoolMapper();

    @Override
    public Result<List<SchoolVO>> search(String keyword) {
        Log.d(TAG, "[test] search");

        Result<SearchSchoolRespDto> result = NetFactory.executeCall(
                () -> schoolApi.searchSchool(new SearchSchoolReqDto(keyword))
        );

        if (!result.isSuccess()) {
            return Result.error(result.getError());
        }

        SearchSchoolRespDto respDto = result.getData();

        if (respDto.getSchools() == null || respDto.getSchools().isEmpty()) {
            Log.d(TAG, "[x] search #40");
            return Result.error("没有搜索结果");
        }

        List<SchoolVO> schoolList = new ArrayList<>();
        respDto.getSchools().forEach(dto -> schoolList.add(mapper.toDomain(dto)));

        return Result.success(schoolList);
    }

    public Result<Boolean> updateSchool(int schoolId, int campusId) {
        Log.d(TAG, "[test] updateSchool");

        Result<Void> result = NetFactory.executeCall(
                () -> schoolApi.updateSchool(new UpdateSchoolReqDto(
                        schoolId,
                        campusId
                ))
        );

        if (!result.isSuccess()) {
            return Result.error(result.getError());
        }

        return Result.success(true);
    }

    @Override
    public void refreshIfNeeded() {

    }
}

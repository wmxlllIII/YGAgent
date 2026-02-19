package com.example.ygagent.data.mapper;

import com.example.ygagent.data.remote.dto.resp.LoginRespDto;
import com.example.ygagent.data.remote.dto.resp.SearchSchoolRespDto;
import com.example.ygagent.domain.entity.School;
import com.example.ygagent.domain.entity.User;

public class SchoolMapper {

    public School toDomain(SearchSchoolRespDto dto) {
        return new School(
                dto.getId(),
                dto.getName(),
                dto.getProvince(),
                dto.getCity()
        );
    }
}

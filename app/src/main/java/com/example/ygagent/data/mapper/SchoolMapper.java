package com.example.ygagent.data.mapper;

import com.example.ygagent.data.remote.dto.resp.SearchSchoolRespDto;
import com.example.ygagent.domain.entity.School;

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

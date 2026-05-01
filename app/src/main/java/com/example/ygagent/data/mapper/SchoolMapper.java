package com.example.ygagent.data.mapper;

import com.example.ygagent.data.dos.SchoolDO;
import com.example.ygagent.data.remote.vo.SchoolVO;

public class SchoolMapper {

    public SchoolVO toDomain(SchoolDO dto) {
        return new SchoolVO(
                dto.getSchoolId(),
                dto.getSchoolName(),
                dto.getProvince(),
                dto.getCity(),
                dto.getCampusId(),
                dto.getCampusName()
        );
    }
}

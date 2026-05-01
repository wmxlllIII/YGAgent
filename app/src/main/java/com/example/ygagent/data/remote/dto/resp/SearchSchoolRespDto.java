package com.example.ygagent.data.remote.dto.resp;

import com.example.ygagent.data.dos.SchoolDO;

import java.util.List;

public class SearchSchoolRespDto {
    private List<SchoolDO> schools;

    public List<SchoolDO> getSchools() {
        return schools;
    }

    public void setSchools(List<SchoolDO> schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return "SearchSchoolRespDto{" +
                "schools=" + schools +
                '}';
    }
}

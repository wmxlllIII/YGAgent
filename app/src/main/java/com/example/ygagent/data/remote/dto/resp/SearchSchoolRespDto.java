package com.example.ygagent.data.remote.dto.resp;

public class SearchSchoolRespDto {
    private int schoolId;
    private String schoolName;
    private String province;
    private String city;

    private int campusId;
    private String campusName;

    public int getSchoolId() {
        return schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public int getCampusId() {
        return campusId;
    }

    public String getCampusName() {
        return campusName;
    }
}

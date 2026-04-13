package com.example.ygagent.data.remote.dto.req;

public class UpdateSchoolReqDto {
    private long schoolId;
    private String schoolName;
    private String province;
    private String city;

    public UpdateSchoolReqDto(long schoolId, String schoolName, String province, String city) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.province = province;
        this.city = city;
    }

    public long getSchoolId() {
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
}

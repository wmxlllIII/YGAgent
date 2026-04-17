package com.example.ygagent.domain.entity;

import java.io.Serializable;

public class School implements Serializable {
    private int schoolId;
    private String schoolName;
    private String province;
    private String city;

    private int campusId;
    private String campusName;


    public School(int schoolId, String schoolName, String province, String city, int campusId, String campusName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.province = province;
        this.city = city;
        this.campusId = campusId;
        this.campusName = campusName;
    }

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

    @Override
    public String toString() {
        return "School{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", campusId=" + campusId +
                ", campusName='" + campusName + '\'' +
                '}';
    }
}

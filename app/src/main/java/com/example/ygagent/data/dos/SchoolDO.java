package com.example.ygagent.data.dos;

public class SchoolDO {
    private int schoolId;
    private String schoolName;
    private String province;
    private String city;

    private int campusId;
    private String campusName;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    @Override
    public String toString() {
        return "SchoolDO{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", campusId=" + campusId +
                ", campusName='" + campusName + '\'' +
                '}';
    }
}

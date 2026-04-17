package com.example.ygagent.data.remote.dto.req;

public class UpdateSchoolReqDto {
    private int schoolId;
    private int campusId;

    public UpdateSchoolReqDto(int schoolId, int campusId) {
        this.schoolId = schoolId;
        this.campusId = campusId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public int getCampusId() {
        return campusId;
    }
}

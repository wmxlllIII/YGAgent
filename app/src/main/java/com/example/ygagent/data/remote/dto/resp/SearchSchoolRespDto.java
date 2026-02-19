package com.example.ygagent.data.remote.dto.resp;

public class SearchSchoolRespDto {
    private long id;
    private String name;
    private String province;
    private String city;

    public long getId() { return id; }
    public String getName() { return name; }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }
}

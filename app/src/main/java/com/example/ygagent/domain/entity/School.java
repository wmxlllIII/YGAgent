package com.example.ygagent.domain.entity;

import java.io.Serializable;

public class School implements Serializable {

    private long id;
    private String name;
    private String province;
    private String city;

    public School(long id, String name, String province, String city) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

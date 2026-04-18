package com.example.ygagent.domain.entity;

public class Task {
    private long id;
    private String title;
    private String content;
    private String location;
    private double price;
    private String genderRequirement;
    private String publisherName;
    private long publishTime;
    private int status;

    public Task(long id, String title, String content, String location,
                double price, String genderRequirement, String publisherName,
                long publishTime, int status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.location = location;
        this.price = price;
        this.genderRequirement = genderRequirement;
        this.publisherName = publisherName;
        this.publishTime = publishTime;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public String getGenderRequirement() {
        return genderRequirement;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public int getStatus() {
        return status;
    }
}

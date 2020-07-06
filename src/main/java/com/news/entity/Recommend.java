package com.news.entity;

public class Recommend {

    private int userId;
    private String type;
    private int browseCount;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(int browseCount) {
        this.browseCount = browseCount;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "userId=" + userId +
                ", type='" + type + '\'' +
                ", browseCount=" + browseCount +
                '}';
    }
}

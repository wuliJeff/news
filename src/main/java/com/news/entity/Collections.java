package com.news.entity;

public class Collections {

    private int userId;
    private int newsId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Override
    public String toString() {
        return "Collections{" +
                "userId=" + userId +
                ", newsId=" + newsId +
                '}';
    }
}

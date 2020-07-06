package com.news.service;

import com.news.entity.News;

import java.util.List;

public interface NewsService {
    /**
     * 获取所有新闻
     *
     * @return 返回新闻列表
     */
    public List<News> getAllNews();

    /**
     * 根据新闻类型获取新闻
     *
     * @param type
     * @return 返回列表
     */
    public List<News> getNewsByType(String type);

    /**
     * 更新新闻浏览量
     *
     * @param newsId
     * @return
     */
    public boolean updateBrowseCount(int newsId);
}

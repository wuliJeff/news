package com.news.dao;

import com.news.entity.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INewsDao {
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
    public List<News> getNewsByType(@Param("type") String type);

    /**
     * 更新新闻浏览量
     *
     * @param newsId
     * @return
     */
    public int updateBrowseCount(@Param("newsId") int newsId);
}

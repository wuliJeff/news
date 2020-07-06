package com.news.service;

import com.news.entity.Recommend;

import java.util.List;

public interface RecommendService {
    /**
     * 记录用户对某类新闻的浏览量
     *
     * @param userId
     * @param type
     * @return
     */
    public boolean addNewRecommend(int userId, String type);

    /**
     * 查询是否存在该记录
     *
     * @param userId
     * @param type
     * @return
     */
    public Recommend isExistRecommend(int userId, String type);

    /**
     * 更新浏览量
     *
     * @param userId
     * @param type
     * @return
     */
    public boolean updateBrowseCount(int userId, String type);

    /**
     * 查询用户最喜欢的类别的新闻类型
     *
     * @param userId
     * @return
     */
    public String getHotTypeById(int userId);
}

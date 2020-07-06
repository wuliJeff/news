package com.news.dao;

import com.news.entity.Recommend;
import org.apache.ibatis.annotations.Param;

public interface IRecommendDao {

    /**
     * 记录用户对某类新闻的浏览量
     *
     * @param userId
     * @param type
     * @return
     */
    public int addNewRecommend(@Param("userId") int userId, @Param("type") String type);

    /**
     * 查询是否存在该记录
     *
     * @param userId
     * @param type
     * @return
     */
    public Recommend isExistRecommend(@Param("userId") int userId, @Param("type") String type);

    /**
     * 更新浏览量
     *
     * @param userId
     * @param type
     * @return
     */
    public int updateBrowseCount(@Param("userId") int userId, @Param("type") String type);

    /**
     * 查询用户最喜欢的类别的新闻类型
     *
     * @param userId
     * @return
     */
    public String getHotTypeById(@Param("userId") int userId);
}

package com.news.dao;

import com.news.entity.Collections;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICollectionsDao {

    /**
     * 对新闻添加收藏
     *
     * @param userId，用户id
     * @param newsId，新闻id
     * @return 添加成功返回用户id
     */
    public int addCollection(@Param("userId") int userId, @Param("newsId") int newsId);

    /**
     * 检查是否存在当前收藏
     *
     * @param userId，用户id
     * @param newsId，新闻id
     * @return
     */
    public Collections isExistCollection(@Param("userId") int userId, @Param("newsId") int newsId);

    /**
     * 对新闻移除收藏
     *
     * @param userId，用户id
     * @param newsId，新闻id
     * @return
     */
    public int removeCollection(@Param("userId") int userId, @Param("newsId") int newsId);

    /**
     * 获取用户的收藏新闻列表
     *
     * @param userId
     * @return 返回新闻列表
     */
    public List<Collections> getCollectionsById(@Param("userId") int userId);
}

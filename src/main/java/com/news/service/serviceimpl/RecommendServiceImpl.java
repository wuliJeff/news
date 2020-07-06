package com.news.service.serviceimpl;

import com.news.dao.IRecommendDao;
import com.news.entity.Recommend;
import com.news.service.RecommendService;
import com.news.util.MapperConfig;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class RecommendServiceImpl implements RecommendService {

    private SqlSession session;

    public RecommendServiceImpl() {
        session = MapperConfig.getSession();
    }

    @Override
    public boolean addNewRecommend(int userId, String type) {
        Recommend recommend = isExistRecommend(userId, type);
        if (recommend == null) { // 不存在记录则插入新记录
            int id = session.getMapper(IRecommendDao.class).addNewRecommend(userId, type);
            if (id > 0) {
                return true;
            }
        } else { // 存在记录则更新浏览量
            updateBrowseCount(userId, type);
            return true;
        }
        return false;
    }

    @Override
    public Recommend isExistRecommend(int userId, String type) {
        return session.getMapper(IRecommendDao.class).isExistRecommend(userId, type);
    }

    @Override
    public boolean updateBrowseCount(int userId, String type) {
        int count = session.getMapper(IRecommendDao.class).updateBrowseCount(userId, type);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String getHotTypeById(int userId) {
        return session.getMapper(IRecommendDao.class).getHotTypeById(userId);
    }

    @Test
    public void test() {
        String hotType = getHotTypeById(2);
        if (hotType != null && !hotType.equals("")) {
            System.out.println(hotType);
        } else {
            System.out.println("error");
        }
    }
}

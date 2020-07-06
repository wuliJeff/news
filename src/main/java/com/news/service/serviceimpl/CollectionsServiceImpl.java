package com.news.service.serviceimpl;

import com.news.dao.ICollectionsDao;
import com.news.entity.Collections;
import com.news.service.CollectionsService;
import com.news.util.MapperConfig;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CollectionsServiceImpl implements CollectionsService {

    private SqlSession session;

    public CollectionsServiceImpl() {
        session = MapperConfig.getSession();
    }

    @Override
    public boolean addCollection(int userId, int newsId) {
        int id = session.getMapper(ICollectionsDao.class).addCollection(userId, newsId);
        if (id > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCollection(int userId, int newsId) {
        int count = session.getMapper(ICollectionsDao.class).removeCollection(userId, newsId);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isExistCollection(int userId, int newsId) {
        Collections collections = session.getMapper(ICollectionsDao.class).isExistCollection(userId, newsId);
        if (collections != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Collections> getCollectionsById(int userId) {
        return session.getMapper(ICollectionsDao.class).getCollectionsById(userId);
    }

    @Test
    public void test() {
        List<Collections> collectionsList = getCollectionsById(1);
        if (collectionsList != null) {
            for (Collections collections : collectionsList) {
                System.out.println(collections.toString());
            }
        }
    }
}

package com.news.service.serviceimpl;

import com.news.dao.INewsDao;
import com.news.entity.News;
import com.news.service.NewsService;
import com.news.util.MapperConfig;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class NewsServiceImpl implements NewsService {

    private SqlSession session;

    public NewsServiceImpl() {
        session = MapperConfig.getSession();
    }

    @Override
    public List<News> getAllNews() {
        return session.getMapper(INewsDao.class).getAllNews();
    }

    @Override
    public List<News> getNewsByType(String type) {
        return session.getMapper(INewsDao.class).getNewsByType(type);
    }

    @Override
    public boolean updateBrowseCount(int newsId) {
        int count = session.getMapper(INewsDao.class).updateBrowseCount(newsId);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        boolean flag = updateBrowseCount(1);
        System.out.println(flag);
    }
}

package com.news.service.serviceimpl;

import com.news.dao.IUserDao;
import com.news.entity.UserInfo;
import com.news.service.UserService;
import com.news.util.MapperConfig;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserServiceImpl implements UserService {

    private SqlSession session;

    public UserServiceImpl() {
        session = MapperConfig.getSession();
    }

    @Override
    public String isExistAccount(String account) {
        if (account == null || account.trim().equals("")) {
            return null;
        } else {
            // 判断是否存在该用户
            String s = session.getMapper(IUserDao.class).isExistAccount(account);
            session.commit();
            return s;
        }
    }

    @Override
    public UserInfo checkPwd(String account, String password) {
        if (account == null || account.trim().equals("")
                || password == null || password.trim().equals("")) {
            return null;
        } else {
            //检查密码是否正确
            UserInfo userInfo = session.getMapper(IUserDao.class).checkPwd(account, password);
            session.commit();
            return userInfo;
        }
    }

    @Override
    public boolean registerUser(UserInfo userInfo) {
        if (userInfo != null) {
            int userId = session.getMapper(IUserDao.class).registerUser(userInfo);
            if (userId >= 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public UserInfo checkTelOrEmail(String account, String telOrEmail) {
        UserInfo userInfo = session.getMapper(IUserDao.class).checkTelOrEmail(account, telOrEmail);
        return userInfo;
    }

    @Override
    public boolean resetPwd(String account, String newPwd) {
        int count = session.getMapper(IUserDao.class).resetPwd(account, newPwd);
        System.out.println(count);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void test() {
        String account = "117583010102";
        String newPwd = "117583010102";
        String telOrEmail = "Allen@163.com";

        if (checkTelOrEmail(account, telOrEmail) != null) {
            System.out.println(resetPwd(account, newPwd));
        } else {
            System.out.println("wrong userInfo");
        }
    }
}
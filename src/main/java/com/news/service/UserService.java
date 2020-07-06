package com.news.service;

import com.news.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    /**
     * 判断是否存在当前账号
     *
     * @param account
     * @return 存在则返回账号，不存在则返回空值
     */
    public String isExistAccount(String account);

    /**
     * 判断是否用户密码是否正确
     *
     * @param account，账户
     * @param password，密码
     * @return
     */
    public UserInfo checkPwd(String account, String password);

    /**
     * 注册用户
     *
     * @param userInfo，用户注册的信息
     * @return 注册成功则返回true，否false
     */
    public boolean registerUser(UserInfo userInfo);

    /**
     * 确认当前账号输入的电话号码、邮箱是否存在
     *
     * @param account，账号
     * @param telOrEmail，电话/邮箱
     * @return 返回一个对象或者null
     */
    public UserInfo checkTelOrEmail(String account, String telOrEmail);

    /**
     * 重新设置密码
     *
     * @param account，账号
     * @param newPwd，新密码
     * @return 更新成功则返回true
     */
    public boolean resetPwd(String account, String newPwd);
}

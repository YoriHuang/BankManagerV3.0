package com.jxau.bank.manager;

/**
 * 业务层接口
 * @version 1.9 2019-7-19
 * @author 黄游迎
 */

import com.jxau.bank.entity.LogBean;
import com.jxau.bank.entity.UserBean;

import java.util.List;

public interface IManager {

    UserBean login(String loginame, String password);  //登录功能说明

    boolean register(UserBean userbean); //注册功能说明

    double inquiry(int userid);  //查询余额功能说明

    boolean deposit(String money, int userid);  //存款功能说明

    //取款功能说明
    boolean withdrawals(String money, int userid);

    boolean transfer(String money, int user, int userid);  //转账

    //根据用户id查找用户其他信息
    UserBean selectUserById(int userid);

    //根据用户id查找用户的操作记录明细
    List<LogBean> selectLogByUserId(int userid);

    //查找系统所有普通用户
    List<UserBean> selectAllUsers();

    //冻结
    boolean freeze(int userId);

    //解冻
    boolean thaw(int userId);
}
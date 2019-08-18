package com.jxau.bank.dao;

/**
 * 持久层接口
 * @version 1.9 2019-7-19
 * @author 黄游迎
 */

import com.jxau.bank.entity.LogBean;
import com.jxau.bank.entity.UserBean;

import java.util.List;

public interface IMySQLDao {

    //获取账户余额
    double getBalance(int userid);

    //登录功能说明
    UserBean login(String loginame);
    //注册功能说明
    boolean register(UserBean ub);

    boolean deposit(double money, int userid);
    boolean withdraws(double money, int userid);
    //获取余额功能说明
    UserBean selectUserByName(String username);
    //转账功能说明
    boolean transfer(double m, int toUserId, int selfid);

    //根据用户id查找用户的其他信息
    UserBean selectUserById(int id);

    //操作记录功能说明
    boolean addrecord(String type, double money, int userid);

    //根据用户id查找用户的操作记录明细
    List<LogBean> selectLogByUserId(int userid);

    //查找系统的所有普通用户的信息
    List<UserBean> selectAllUsers();

    //冻结账户
    boolean freeze(int userid);

    //解冻账户
    boolean thaw(int userid);
}

package com.jxau.bank.entity;

/**
 * 封装了用户操作明细数据
 * @version 1.9 2019-7-19
 * @author 黄游迎
 */
public class LogBean {
    private int log_id;
    private String log_type;
    private double money;
    private int userid;
    private String time;
    private double user_balance;

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public String getLog_type() {
        return log_type;
    }

    public void setLog_type(String log_type) {
        this.log_type = log_type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getUser_balance() {
        return user_balance;
    }

    public void setUser_balance(double user_balance) {
        this.user_balance = user_balance;
    }
}

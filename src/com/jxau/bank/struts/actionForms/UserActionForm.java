package com.jxau.bank.struts.actionForms;

import org.apache.struts.action.ActionForm;

public class UserActionForm extends ActionForm {
    private int userid;
    private String username;
    private String password;
    private int flag;
    private double balance;
    private String registime;
    private int admin;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid){
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getRegistime() {
        return registime;
    }

    public void setRegistime(String registime) {
        this.registime = registime;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
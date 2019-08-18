package com.jxau.bank.struts.actionForms;

import org.apache.struts.action.ActionForm;

public class TransferActionForm extends ActionForm {
    private String money;
    private String toUserId;

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }
}

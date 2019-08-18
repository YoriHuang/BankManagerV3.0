package com.jxau.bank.struts.actionForms;

import org.apache.struts.action.ActionForm;

public class depositWithdrawsActionForm extends ActionForm {

    private String money;  //存款金额

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }


}
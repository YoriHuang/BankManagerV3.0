package com.jxau.bank.struts.actions;

import com.jxau.bank.manager.ManagerImpl;
import com.jxau.bank.struts.actionForms.depositWithdrawsActionForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepositAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        depositWithdrawsActionForm daf = (depositWithdrawsActionForm)form;
        String money = daf.getMoney();
        int userId = (int)request.getSession().getAttribute("userId");

        boolean flag = ManagerImpl.getInstance().deposit(money, userId);
        if(flag){
            request.setAttribute("depositInfo", "交易成功！存款金额：" + money + "元！");
        }else {
            request.setAttribute("depositInfo", "交易异常终止！请重试！");
        }
        return mapping.findForward("deposit");
    }
}

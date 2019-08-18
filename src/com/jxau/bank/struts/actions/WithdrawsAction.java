package com.jxau.bank.struts.actions;

import com.jxau.bank.exception.withdraws.BalanceNotEnoughException;
import com.jxau.bank.manager.ManagerImpl;
import com.jxau.bank.struts.actionForms.depositWithdrawsActionForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WithdrawsAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        depositWithdrawsActionForm daf = (depositWithdrawsActionForm)form;
        String money = daf.getMoney();
        int userId = (int)request.getSession().getAttribute("userId");

        try {
            boolean flag = ManagerImpl.getInstance().withdrawals(money, userId);
            if(flag) {
                request.setAttribute("withdrawsInfo", "交易成功！取款金额：" + money + "元！");
                return mapping.findForward("withdraws_success");
            }else{
                request.setAttribute("withdrawsInfo", "交易异常终止！请重试！");
            }
        }catch(BalanceNotEnoughException bnee){
            request.setAttribute("withdrawsInfo", "账户余额不足！");
        }
        return mapping.findForward("withdraws_error");
    }
}

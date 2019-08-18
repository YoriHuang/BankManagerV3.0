package com.jxau.bank.struts.actions;

import com.jxau.bank.exception.transfer.ToUserNotExistException;
import com.jxau.bank.exception.withdraws.BalanceNotEnoughException;
import com.jxau.bank.manager.ManagerImpl;
import com.jxau.bank.struts.actionForms.TransferActionForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TransferAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        TransferActionForm daf = (TransferActionForm)form;
        String money = daf.getMoney();
        int toUserId = Integer.parseInt(daf.getToUserId());
        int userId = (int)request.getSession().getAttribute("userId");

        try {
            boolean flag = ManagerImpl.getInstance().transfer(money, toUserId, userId);
            if(flag) {
                request.setAttribute("transferInfo", "交易成功！转账金额：" + money + "元！");
                return mapping.findForward("transfer_success");
            }else{
                request.setAttribute("transferInfo", "交易异常终止！请重试！");
            }
        }catch(ToUserNotExistException tunee){
            request.setAttribute("transferInfo", "对方账户不存在！");
        }catch(BalanceNotEnoughException bnee){
            request.setAttribute("transferInfo", "账户余额不足！");
        }
        return mapping.findForward("transfer_error");
    }
}

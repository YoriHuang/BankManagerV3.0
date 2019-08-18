package com.jxau.bank.struts.actions;

import com.jxau.bank.manager.ManagerImpl;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InquiryAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        double balance = ManagerImpl.getInstance().inquiry((int)request.getSession().getAttribute("userId"));
        request.setAttribute("balance", balance);
        return mapping.findForward("inquiry");
    }
}

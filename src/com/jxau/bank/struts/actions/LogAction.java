package com.jxau.bank.struts.actions;

import com.jxau.bank.entity.LogBean;
import com.jxau.bank.manager.ManagerImpl;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LogAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<LogBean> logs = ManagerImpl.getInstance().selectLogByUserId((int)request.getSession().getAttribute("userId"));
        request.setAttribute("logs", logs);
        return mapping.findForward("log");
    }
}

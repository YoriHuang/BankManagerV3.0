package com.jxau.bank.struts.actions;

import com.jxau.bank.entity.UserBean;
import com.jxau.bank.manager.ManagerImpl;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ThawAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        int userId = Integer.parseInt(request.getParameter("userId"));

        boolean flag = ManagerImpl.getInstance().thaw(userId);
        if(flag){
            List<UserBean> users = ManagerImpl.getInstance().selectAllUsers();
            request.setAttribute("users", users);
            request.setAttribute("freezeThawInfo", "已解冻！");
        }else {
            request.setAttribute("freezeThawInfo", "操作异常终止！请重试！");
        }
        return mapping.findForward("thaw");
    }
}

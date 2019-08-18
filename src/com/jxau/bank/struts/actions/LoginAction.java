package com.jxau.bank.struts.actions;

import com.jxau.bank.entity.UserBean;
import com.jxau.bank.exception.login.PasswordErrorException;
import com.jxau.bank.exception.login.UserNotExistException;
import com.jxau.bank.manager.ManagerImpl;
import com.jxau.bank.struts.actionForms.UserActionForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        UserActionForm uaf = (UserActionForm)form;
        String username = uaf.getUsername();
        String password = uaf.getPassword();
        String LoginInfo = "";
        try {
            UserBean userbean = ManagerImpl.getInstance().login(username, password);
            request.getSession().setAttribute("userId", userbean.getUserid());
            request.getSession().setAttribute("username", userbean.getUsername());
            if(userbean.getAdmin() == 1){
                return mapping.findForward("success_admin");
            }else if(userbean.getAdmin() == 0){
                return mapping.findForward("success_user");
            }
        }catch(UserNotExistException unee){
            LoginInfo = "用户不存在！";
        }catch(PasswordErrorException pee){
            LoginInfo = "密码错误！";
        }
        request.setAttribute("LoginInfo", LoginInfo);
        return mapping.findForward("error");
    }
}

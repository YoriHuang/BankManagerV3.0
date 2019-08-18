package com.jxau.bank.struts.actions;


import com.jxau.bank.entity.UserBean;
import com.jxau.bank.exception.register.UserExistException;
import com.jxau.bank.manager.ManagerImpl;
import com.jxau.bank.struts.actionForms.UserActionForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        UserActionForm uaf = (UserActionForm)form;
        String RegisterInfo = "";

        UserBean userbean = new UserBean();
        BeanUtils.copyProperties(userbean, uaf);

        try {
            boolean flag = ManagerImpl.getInstance().register(userbean);
            if(flag) {
                RegisterInfo = "注册成功！";
                request.setAttribute("RegisterInfo", RegisterInfo);
                return mapping.findForward("success");
            }else{
                RegisterInfo = "注册异常终止！请重试！";
                request.setAttribute("RegisterInfo", RegisterInfo);
            }
        }catch(UserExistException uee){
            RegisterInfo = "该用户名已被注册！";
        }
        request.setAttribute("RegisterInfo",RegisterInfo);
        return mapping.findForward("error");
    }
}

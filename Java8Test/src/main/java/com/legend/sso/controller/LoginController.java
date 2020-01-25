package com.legend.sso.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 登录的控制器
 *
 * @author legend
 */
@RequestMapping("/sso")
public class LoginController {

        @RequestMapping("/login")
        public String login(String username, String password, HttpServletRequest req) {
            this.checkLoginInfo(username, password);
            req.getSession().setAttribute("isLogin", true);
            return "success";
        }

    private void checkLoginInfo(String username, String password) {
        //查询数据库信息

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session != null) {
            session.invalidate();//触发LogoutListener
        }
        return "redirect:/";
    }


    private String getToken(){
        return UUID.randomUUID().toString();
    }

}

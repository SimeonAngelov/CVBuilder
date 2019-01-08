package com.cvworld.Interseptors;

import com.cvworld.dao.BaseServiser;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterseptor extends HandlerInterceptorAdapter {

 private BaseServiser baseServicer = new BaseServiser();

    // Called before handler method invocation
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        if (baseServicer.getCurrentUserInfo(req.getSession()) == null) {
            res.sendRedirect(req.getContextPath() + "/login");
            return false;
        }
        return true;
    }

}
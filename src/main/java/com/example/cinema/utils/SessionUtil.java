package com.example.cinema.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    private static SessionUtil sessionUtil = null;
    public static SessionUtil khoiTaoSession(){
        return sessionUtil == null ? new SessionUtil() : sessionUtil;
    }

    public void luuSession(HttpServletRequest req, String key, Object value){
        req.getSession().setAttribute(key, value);
    }

    public void laySession(HttpServletRequest req, String key){
         req.getSession().getAttribute(key);
    }

    public void xoaSession(HttpServletRequest req, String key){
        req.getSession().removeAttribute(key);
    }
}

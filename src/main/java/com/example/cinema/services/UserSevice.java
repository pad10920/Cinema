package com.example.cinema.services;

import com.example.cinema.dao.UserDAO;
import com.example.cinema.model.User;
import com.example.cinema.utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;

public class UserSevice {

    UserDAO userDAO = UserDAO.khoiTaoUserDAO();
    SessionUtil sessionUtil = SessionUtil.khoiTaoSession();

    private static UserSevice service = null;
    public static UserSevice khoiTaoUserService(){
        return service == null ? new UserSevice() : service;
    }

    public boolean dangNhap(HttpServletRequest req, String username, String password){
        User user = userDAO.layUserBangTkVaMk(username, password);
        if (user == null){
            return false;
        }
        else{
            sessionUtil.luuSession(req, "USER", user);
            return true;
        }
    }
}

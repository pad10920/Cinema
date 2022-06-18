package com.example.cinema.services;

import com.example.cinema.dao.UserDAO;
import com.example.cinema.model.User;
import com.example.cinema.utils.EmailUtil;
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

    // kiem tra ton tai ten tai khoan va email (username, email)
    // result = 1 (tai khoan da ton tai), result = 2 (email da ton tai), result = 3 (ton tai ca 2)
    public int dangKy(String username, String email){
        int result = 0;
        User userBangTk = userDAO.layUserBangTk(username);
        User userBangEmail = userDAO.layUserBangEmail(email);
        if (userBangTk != null)
            result = 1;
        if (userBangEmail != null)
            result = 2;
        if (userBangTk != null && userBangEmail != null)
            result = 3;
        return result;
    }

    public void quenMatKhau(String email){
        User user = userDAO.layUserBangEmail(email);
        if (user != null){
            String nguoiNhan = user.getEmail();
            String chude = "Quên mật khẩu";
            String noiDung =
                    "<b style='font-size=14px';>Beta Cinema kính chào " + user.getHoTen() + "</b><br><br>" +
                    "Tên tài khoản của bạn là: <b>" +user.getUsername() + "</b><br>" +
                    "Mật khẩu của bạn là: <b>" +user.getPassword() + "</b><br><br>" +
                    "Trân trọng!";
            EmailUtil.sendEmail(nguoiNhan, chude, noiDung);
        }
    }

    // luu user
    public void luuUser(User user){
        userDAO.luuUser(user);
    }
}

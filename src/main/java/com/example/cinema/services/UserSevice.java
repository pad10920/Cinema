package com.example.cinema.services;

import com.example.cinema.dao.UserDAOD;
import com.example.cinema.model.UserD;
import com.example.cinema.utils.EmailUtil;
import com.example.cinema.utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;

public class UserSevice {

    UserDAOD userDAOD = UserDAOD.khoiTaoUserDAO();
    SessionUtil sessionUtil = SessionUtil.khoiTaoSession();

    private static UserSevice service = null;
    public static UserSevice khoiTaoUserService(){
        return service == null ? new UserSevice() : service;
    }

    public boolean dangNhap(HttpServletRequest req, String username, String password){
        UserD userD = userDAOD.layUserBangTkVaMk(username, password);
        if (userD == null){
            return false;
        }
        else{
            sessionUtil.luuSession(req, "USER", userD);
            return true;
        }
    }

    // kiem tra ton tai ten tai khoan va email (username, email)
    // result = 1 (tai khoan da ton tai), result = 2 (email da ton tai), result = 3 (ton tai ca 2)
    public int dangKy(String username, String email){
        int result = 0;
        UserD userDBangTk = userDAOD.layUserBangTk(username);
        UserD userDBangEmail = userDAOD.layUserBangEmail(email);
        if (userDBangTk != null)
            result = 1;
        if (userDBangEmail != null)
            result = 2;
        if (userDBangTk != null && userDBangEmail != null)
            result = 3;
        return result;
    }

    public void quenMatKhau(String email){
        UserD userD = userDAOD.layUserBangEmail(email);
        if (userD != null){
            String nguoiNhan = userD.getEmail();
            String chude = "Quên mật khẩu";
            String noiDung =
                    "<b style='font-size=14px';>Beta Cinema kính chào " + userD.getHoTen() + "</b><br><br>" +
                    "Tên tài khoản của bạn là: <b>" + userD.getUsername() + "</b><br>" +
                    "Mật khẩu của bạn là: <b>" + userD.getPassword() + "</b><br><br>" +
                    "Trân trọng!";
            EmailUtil.sendEmail(nguoiNhan, chude, noiDung);
        }
    }

    // luu userD
    public void luuUser(UserD userD){
        userDAOD.luuUser(userD);
    }
}

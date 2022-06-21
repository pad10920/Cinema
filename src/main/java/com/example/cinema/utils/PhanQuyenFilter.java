package com.example.cinema.utils;

import com.example.cinema.model.UserD;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class PhanQuyenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String path = httpServletRequest.getServletPath();
        HttpSession session = httpServletRequest.getSession();
        UserD userD = (UserD) session.getAttribute("USER");

        // admin phan quyen
        if (path.startsWith("/quan-ly")){
            if (userD == null)
                httpServletRequest.getRequestDispatcher("/").forward(request, response);
            else if (userD.getQuyen().compareTo("ROLE_ADMIN")!=0)
                httpServletRequest.getRequestDispatcher("/").forward(request, response);
        }

        // phan quyen nguoi dung
        if (path.startsWith("/tai-khoan") && userD == null){
            httpServletRequest.getRequestDispatcher("/dang-nhap").forward(request, response);
        }

        // dang nhap, dang xuat
        if (path.startsWith("/dang-nhap") && userD != null){
            httpServletRequest.getRequestDispatcher("/").forward(request, response);
        }

        chain.doFilter(request, response);
    }
}

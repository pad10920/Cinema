<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<div class="nav-bar">
    <a href="/">
        <div style="display: flex; align-items: center; justify-content: center;">
            <div class="logo-navBar"></div>
            <div class="text-logo">META</div>
        </div>
    </a>
    <div class="select-navBar">
        <select name="cars" id="cars">
            <option value="volvo">META BẮC GIANG</option>
            <option value="saab">META HÀ NỘI</option>
            <option value="opel">META THÁI NGUYÊN</option>
            <option value="audi">META BẮC NINH</option>
        </select>
    </div>
    <div class="menu-navBar">
        <ul>
            <a href="./lich_chieu_phim.html"><li>LỊCH CHIẾU PHIM THEO RẠP</li></a>
            <a href="./cinema.html"><li>PHIM</li></a>
            <a href="./thong_tin_rap.html"><li>RẠP</li></a>
            <a href="./price.html"><li>GIÁ VÉ</li></a>
        </ul>
    </div>
    <c:if test="${empty USER}">
        <a href="/dang-nhap" >
            <div class="signIn-navBar"><i class="fa-solid fa-user" style="padding-right: 8px"></i>Login</div>
        </a>
    </c:if>
    <c:if test="${not empty USER}">
        <a href="/tai-khoan">
            <div class="signIn-navBar"><i class="fa-solid fa-user" style="padding-right: 8px"></i>${USER.username}</div>
        </a>
        <a href="/dang-xuat">
            <div class="signIn-navBar">Thoát</div>
        </a>
    </c:if>
</div>
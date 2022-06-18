
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="icon" href="../static/img/32.png" type="image/gif" sizes="16x16">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Permanent+Marker&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../static/css/dangnhap.css">
    <link rel="stylesheet" href="../static/css/home.css">
</head>
<body>

<%@ include file="manh-navbar.jsp"%>

<div class="body">
    <div class="login">
        <div class="dn_dk">
            <a href="/dang-nhap"><button class="dn">ĐĂNG NHẬP</button></a>
            <button class="active dk">ĐĂNG KÝ</button>
        </div>

        <form class="login_form form1" method="post" id="form-dangky" onsubmit="return false">
            <div class="info">
                    <span>
                            Tên tài khoản
                    </span>
                <input type="text" name="username" id="username" placeholder="Tên tài khoản" minlength="6" maxlength="20"
                        oninput="kiemTraHopLeInput(this)">
            </div>
            <div class="info">
                    <span>
                            Email
                    </span>
                <input type="text" name="email" id="email" placeholder="Email"
                       oninput="kiemTraHopLeEmail(this)">
            </div>
            <div class="info">
                    <span>
                            Họ tên
                    </span>
                <input type="text" name="hovaten" id="hovaten" placeholder="Họ tên" minlength="2" maxlength="20"
                       oninput="kiemTraHopLeInput(this)">
            </div>
            <div class="info">
                    <span>
                            Số điện thoại
                    </span>
                <input type="tel" name="sdt" id="sdt" placeholder="Số điện thoại" minlength="10" maxlength="10"
                       oninput="kiemTraHopLeInput(this)">
            </div>
            <div class="info">
                    <span>
                            Mật khẩu
                    </span>
                <input type="password" name="password" id="password" placeholder="Mật khẩu" minlength="6" maxlength="20"
                       oninput="kiemTraHopLeInput(this)">
            </div>
            <div class="info">
                    <span>
                            Xác nhận lại mật khẩu
                    </span>
                <input type="password" name="re-password" id="re-password" placeholder="Xác nhận lại mật khẩu"
                       oninput="kiemTraTrungMatKhau(this)">
            </div>
            <span class="chu-do phan-hoi" hidden></span>
            <button onclick="dangKyTaiKhoan()">Đăng ký</button>
        </form>
    </div>
</div>
<div class="content-7">
    <div class="footer">
        <div class="footer-1">
            <div class="bg-footer">META</div>
            <p>Address: Km10 - Nguyễn Trãi - Hà Nội</p>
            <p>Phone: 0123456789</p>
            <p>Email: meta@gmail.com</p>
        </div>
        <div class="footer-2">
            <h4>Usefull Links</h4>
            <ul>
                <li>About Us</li>
                <li>Who are you</li>
                <li>Contact</li>
                <li>Our Sitemap</li>
                <li>Testmonials</li>
                <li>Projects</li>
            </ul>
        </div>
        <div class="footer-3">
            <a href="https://www.facebook.com/">
                <div class="vong-tron"><i class="fa-brands fa-facebook-f chinh"></i></div>
            </a>
            <div class="vong-tron"><i class="fa-brands fa-youtube chinh"></i></div>
            <div class="vong-tron"><i class="fa-brands fa-twitter chinh"></i></div>
            <div class="vong-tron"><i class="fa-brands fa-pinterest-p chinh"></i></div>
        </div>
    </div>
    <div class="footer-withlove">
        <div class="vector-3"></div>
        <p>Copyright ©2022 All rights reserved | This template is made with  by <a href="https://www.facebook.com/">Meta</a></p>
    </div>

</div>
<script src="../static/js/dungchung.js"></script>
<script src="../static/js/dangky.js"></script>
</body>
</html>
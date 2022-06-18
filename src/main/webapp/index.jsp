<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link rel = "icon" href =
            "static/img/32.png"
          type = "image/x-icon">
    <link rel="stylesheet" href="../static/css/home.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Permanent+Marker&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <%@ include file="view/manh-navbar.jsp"%>
    <div class="slide-show">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active pic1">
                    <!-- <img src="https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg" alt="Los Angeles" style="width:100%;"> -->
                </div>

                <div class="item pic2">
                    <!-- <img src="https://media.istockphoto.com/photos/villefranche-on-sea-in-evening-picture-id1145618475?k=20&m=1145618475&s=612x612&w=0&h=_mC6OZt_eWENYUAZz3tLCBTU23uvx5beulDEZHFLsxI=" alt="Chicago" style="width:100%;"> -->
                </div>

                <div class="item pic3">
                    <!-- <img src="https://static.toiimg.com/photo/msid-58515713,width-96,height-65.cms" alt="New york" style="width:100%;"> -->
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="container">
        <div class="cinema-menu">
            <button class="active" type-cinema="1">PHIM SẮP CHIẾU</button>

            <button type-cinema="2">PHIM ĐANG CHIẾU</button>
            <button type-cinema="3">SUẤT CHIẾU ĐẶC BIỆT</button>
        </div>
        <div class="cinema-list">


        </div>
    </div>
    <!-- footer -->
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
    <script src="../static/js/trangchu.js"></script>
</body>
</html>

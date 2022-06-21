<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>QuanLyPhim</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='../static/css/quanly.css'>

    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
</head>

<body>
    <div class="noidung"><strong>QUẢN LÝ</strong></div>
    <div class="phanthan">
        <!--Phần bar chọn chức năng-->
        <div class="bar">
            <a href="/quan-ly/quanlyphim" style="color: white;">
                <div class="quanly phimD"> <span class="round">QUẢN LÝ PHIM</div>
            </a>
            <a href="/quan-ly/quanlysuatchieu">
                <div class="quanly">QUẢN LÝ XUẤT CHIẾU</div>
            </a>
            <a href="/quan-ly/thongke">
                <div class="quanly thongke"><i class="fa fa-chevron-right"></i></span>
                    &ensp;THỐNG KÊ</div>
            </a>
        </div>
        <!--Phần quản lý phimD-->
        <div class="quanlybox">
            <div class="loc">
                <div class="thongke-2">THỐNG KÊ</div>
                <div id="kind">
                    <div style="margin-bottom: 10px;">TỪ</div>
                    <input style="font-size: 18px;" id="timebd_1" type="date" value="2000-01-01">
                    <div style="margin-bottom: 10px;" >ĐẾN</div>
                    <input style="font-size: 18px;" id="timekt_1" type="date" value="2030-01-01">
                </div>
                <br>

                <button class="an-loc" onclick="checktime()">LỌC</button>
            </div>

            <div class="bangthongke">
                <div class="motthe">
                    <div class="item-tk">
                        ID
                    </div>
                    <div class="item-tk">
                        TÊN PHIM
                    </div>
                    <div class="item-tk">
                        THỜI GIAN MUA
                    </div>
                    <div class="item-tk">
                        GIÁ VÉ
                    </div>
                    <div class="item-tk">
                        TÊN NGƯỜI MUA
                    </div>
                </div>
                <div class="danhsach-ve">
                    <div class="item-thongke">
                        ID
                    </div>
                    <div class="item-thongke">
                        TÊN PHIM
                    </div>
                    <div class="item-thongke">
                        THỜI GIAN MUA
                    </div>
                    <div class="item-thongke">
                        GIÁ VÉ
                    </div>
                    <div class="item-thongke">
                        TÊN NGƯỜI MUA
                    </div>
                </div>
            </div>
            <script src='../static/js/dungchung.js'></script>
            <script src='../static/js/quanlythongke.js'></script>
        </div>
</body>

</html>
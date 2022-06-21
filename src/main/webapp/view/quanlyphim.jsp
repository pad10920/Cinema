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
                <div class="quanly phimD"> <span class="round"><i class="fa fa-chevron-right"></i></span>
                    &ensp;QUẢN LÝ PHIM</div>
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
            <!--Lựa chọn sửa hoặc thêm-->
            <nav class="nav">
                <a href="#" class="nav-item is-active" active-color="white" value="themPhim">THÊM PHIM</a>
                <a href="#" class="nav-item" active-color="white" value="suaPhim">SỬA PHIM</a>
                <span class="nav-indicator"></span>
            </nav>
            <!--Phần thêm phimD-->
            <div class="nhap active" id="themphim">
                <div id="formdata1">
                    <div class="group">
                        <label>Tên Phim</label>
                        <input class="onhap" id="phimten" type="text" name="ten" required>
                    </div>
                    <div class="group">
                        <label>Thời Lượng(phút)</label>
                        <input class="onhap" id="thoiluong" type="number" name="thoiluong">
                    </div>
                    <div class="group">
                        <label>Mô Tả</label>
                        <textarea class="onhap" id="mota" rows="4" cols="50" ></textarea>
                    </div>
                    <div class="group">
                        <label>Quốc Gia</label>
                        <input class="onhap" id="quocgia" type="text" name="quocgia">
                    </div>
                    <div class="group">
                        <label>Trạng Thái</label>
                        <select class="onhap" name="trangthai" id="trangthai">
                            <option selected disabled>Chọn trạng thái</option>
                            <option value="0">Phim sắp chiếu</option>
                            <option value="1">Phim đang chiếu</option>
                            <option value="2">Phim đặc biệt</option>
                        </select>
                    </div>
                    <div class="group">
                        <label>Thể Loại</label>
                        <div class="theLoaiPhim">
                            <div class="selectBox" onclick="showTheLoaiPhim('checkboxes', 'theLoaiPhim')">
                                <select>
                                    <option>Chọn thể loại phimD</option>
                                </select>
                                <div class="overSelect"></div>
                            </div>
                            <div id="checkboxes" class="checkboxtheloai">
<%--                                <label for="one">--%>
<%--                                    <input type="checkbox" id="one" />First checkbox</label>--%>
<%--                                <label for="two">--%>
<%--                                    <input type="checkbox" id="two" />Second checkbox</label>--%>
<%--                                <label for="three">--%>
<%--                                    <input type="checkbox" id="three" />Third checkbox</label>--%>
                            </div>
                        </div>
                    </div>
                    <div class="group">
                        <label for="myfile">Thêm Ảnh</label>
                        <input class="onhap" type="file" id="file-upload" ><br>
                    </div>
                    <button class="sub" id="create"> Thêm</button>
                </div>
            </div>
            <!--Phần sửa phimD-->
            <div class="nhap" id="suaphim">
                <div>
                    <div class="group">
                        <label>Sửa Tên Phim</label>
                        <input class="onhap-2" id="tensua" type="text" name="tensua"  required>
                    </div>
                    <div class="group">
                        <label>Thời Lượng</label>
                        <input class="onhap-2" id="thoiluongsu" type="number" name="thoiluongsua" required>
                    </div>
                    <div class="group">
                        <label>Mô Tả</label>
                        <textarea class="onhap-2" id="motasua" name="motasua" rows="4" cols="50"></textarea>

                    </div>
                    <div class="group">
                        <label>Quốc Gia</label>
                        <input class="onhap-2" id="quocgiasu" name="quocgiasua" type="text" required>

                    </div>
                    <div class="group">
                        <label>Trạng Thái</label>
                        <select class="onhap-2" name="trangthaisua" id="trangthaisua">
                            <option selected disabled>Chọn trạng thái</option>
                            <option value="0">Phim sắp chiếu</option>
                            <option value="1">Phim đang chiếu</option>
                            <option value="2">Phim đặc biệt</option>
                        </select>
                    </div>
                    <div class="group" id="suaTheLoai">
                        <label>Thể Loại</label>
                        <div class="theLoaiPhim">
                            <div class="selectBox" onclick="showTheLoaiPhim('cbTheLoaiSua')">
                                <select>
                                    <option>Chọn thể loại phimD</option>
                                </select>
                                <div class="overSelect"></div>
                            </div>
                            <div id="cbTheLoaiSua" class="checkboxtheloai" style="display: block">
                                <%--                                <label for="one">--%>
                                <%--                                    <input type="checkbox" id="one" />First checkbox</label>--%>
                                <%--                                <label for="two">--%>
                                <%--                                    <input type="checkbox" id="two" />Second checkbox</label>--%>
                                <%--                                <label for="three">--%>
                                <%--                                    <input type="checkbox" id="three" />Third checkbox</label>--%>
                            </div>
                        </div>
                    </div>
                    <button class="sub" id="hhh" onclick="handleSetForm()">Sửa</button>
                    
                </div>
                <div class="search">
                    <!--Tìm tên phimD-->
                    <div class="tim" id="az">TÌM TÊN PHIM</div>
                    <div>

                        <input id="nhapten" type="text" name="search" placeholder="Search..">
                        <button class="sub2" value="TÌM KIẾM" id="tim" onclick="timPhim()">TÌM KIẾM</button>
                        <button onclick="layListPhim()" class="sub2" value="TÌM KIẾM" id="tim2">TẤT CẢ</button>
                    </div>
                    <!--Bảng hiển thị phimD tìm kiếm-->
                    <div class="danhsach">
                        <div class="bangphim">
                            <div class="truong">
                                <div class="dt">Tên Phim</div>
                                <div class="dt">Thời Lượng</div>
                                <div class="dt">Quốc Gia</div>
                                <div class="dt">Trạng Thái</div>
                                <div class="dt">Thể Loại</div>
                            </div>
                            <div id="listphim1" class="xx">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script src='../static/js/dungchung.js'></script>
            <script src='../static/js/quanlyphim.js'></script>
        </div>
</body>

</html>
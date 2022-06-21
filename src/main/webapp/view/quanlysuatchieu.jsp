<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Quanlyxuat</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='../static/css/quanly.css'>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
    <div class="noidung"><strong>QUẢN LÝ</strong></div>
    <div class="phanthan">
        <!--Phần bar chọn chức năng-->
        <div class="bar">
            <a href="/quan-ly/quanlyphim" style="color: white;">
                <div class="quanly">QUẢN LÝ PHIM</div>
            </a>
            <a href="/quan-ly/quanlysuatchieu">
                <div class="quanly xuat"> <span class="round"><i class="fa fa-chevron-right"></i></span>
                    &ensp;QUẢN LÝ XUẤT CHIẾU</div>
            </a>
            <a href="/quan-ly/thongke">
                <div class="quanly thongke"><i class="fa fa-chevron-right"></i></span>
                    &ensp;THỐNG KÊ</div>
            </a>
        </div>
        <div class="quanlyxuatbox">
            <nav class="nav-2">
                <a href="#" class="nav-2-item is-active" active-color="white" value="themXuat">THÊM XUẤT CHIẾU</a>
                <a href="#" class="nav-2-item" active-color="white" value="suaXuat">SỬA XUẤT CHIẾU</a>
                <span class="nav-2-indicator"></span>
            </nav>
            <div class="themx active" id="themXuat">
                <div class="chonphim" onclick="chon()">Chọn phimD</div>
                <div class="ds2">
                    <div class="dong" onclick="dong()">X</div>
                    <div class="bangphim-2">
                        <div class="truong-2">
                            <div class="dt-2">Tên Phim</div>
                            <div class="dt-2">Thời Lượng</div>
                            <div class="dt-2">Quốc Gia</div>
                            <div class="dt-2">Trạng Thái</div>
                            <div class="dt-2">Thể Loại</div>
                        </div>
                        <div id="danhSachPhim">
                            <div class="xx-2" onclick="sc()">
                                <div class="ds-2">MÙA CỎ ÚA</div>
                                <div class="ds-2">Thời Lượng</div>
                                <div class="ds-2">Quốc Gia</div>
                                <div class="ds-2">Trạng Thái</div>
                                <div class="ds-2">Thể Loại</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="nhapthongtin" id="getid">
                    <form onsubmit="return false">
                        <div class="group">
                            <label>Phim</label>
                            <input class="onhap-3" id="tenphim" type="text" required disabled>
                        </div>
                        <div class="group">
                            <label>Ngày chiếu</label>
                            <input class="onhap-3" id="thoigianngay" type="date" min="2000-01-02" required onchange="layDanhSachPhong()">
                        </div>

                        <div class="group">
                            <label>Thời Gian Bắt Đầu</label>
                            <input class="onhap-3" id="thoigianbd" type="time" required onchange="layDanhSachPhong()">
                        </div>

                        <div class="group">
                            <label>Thời Gian Kết Thúc</label>
                            <input class="onhap-3" id="thoigiankt" type="time" required onchange="layDanhSachPhong()">
                        </div>
                        <div class="group">
                            <label>Chọn rạp</label>
                            <select class="onhap-3" name="chonrap" id="chonrap" onchange="layDanhSachPhong()">
                                <option selected disabled>Chọn</option>
                            </select>
                        </div>
                        <div class="group">
                            <label>Chọn phòng chiêu</label>
                            <div id="chonPhongChieu">
                            </div>
                        </div>
                        <div class="group">
                            <label>Giá Vé</label>
                            <input class="onhap-3" id="giave" type="text" required>
                        </div>
                        <input class="sub" value="THÊM" onclick="themSuatChieu()">
                    </form>
                </div>
            </div>
            <div class="themx" id="suaXuat">
                <div class="chonrap">
                    <div class="tieude" onclick="chon2()">CHỌN RẠP</div>
                </div>
                <div class="danhsach2">
                    <div class="dong2" onclick="dong2()">X</div>
                    <div id="danhsachrapsua">
                    </div>
                </div>
                <div class="danhsach-xc">
                    <div class="quaylai" onclick="back()"><i class="fa fa-arrow-circle-left" style="font-size:36px"></i>
                    </div>
                    <div class="item-xc">
                        <div class="j">NGÀY CHIẾU</div>
                        <div class="j">THỜI GIAN BẮT ĐẦU</div>
                        <div class="j">THỜI GIAN KẾT THÚC</div>
                        <div class="j">GIÁ VÉ</div>
                    </div>
                    <div class="item-xc-2">
                        <div id="listshowsua">

                        </div>
                    </div>
                </div>
                <div class="lop-phu"></div>
                <div class="nhapsuaxc">
                    <div class="dulieusua">
                        <div class="dongsua" onclick="dongsua()">X</div>
                        <div id="dulieushowsu">
                            <div class="group-2" style="font-size: 17px; color: rgb(19, 19, 19);" id="tenphimsua">
                                TÊN PHIM
                            </div>
                            <div class="group-2">
                                <select class="onhap-4" id="showListPhimSua">
                                </select>
                            </div>
                            <div class="group-2">
                                <label>Giá Vé</label>
                                <input class="onhap-4" type="text" id="giavesua">
                            </div>
                        </div>
                        <button class="sub-3" onclick="commitSuaShow()">Sửa</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src='../static/js/dungchung.js'></script>
    <script src="../static/js/quanlysuatchieu.js"></script>
</body>

</html>
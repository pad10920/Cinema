//phần xử lý giao diện
var indicator = document.querySelector('.nav-indicator');
var items = document.querySelectorAll('.nav-item');
var content = document.querySelectorAll('.nhap')
var themPhim = document.querySelector("#themphim");
var suaPhim = document.querySelector("#suaphim");
function handleIndicator(el) {
    items.forEach(function (item) {
        item.classList.remove('is-active');
        item.removeAttribute('style');
    });

    indicator.style.width = "".concat(el.offsetWidth, "px");
    indicator.style.left = "".concat(el.offsetLeft, "px");
    indicator.style.backgroundColor = el.getAttribute('active-color');
    el.classList.add('is-active');
    el.style.color = el.getAttribute('active-color');

}
items.forEach(function (item) {
    item.addEventListener('click', function (e) {
        if (item.getAttribute("value") == "themPhim") {
            themPhim.style.display = "block";
            suaPhim.style.display = "none";
        }
        else {
            suaPhim.style.display = "flex";
            themPhim.style.display = "none";
        }
        handleIndicator(e.target);

    });
    item.classList.contains('is-active') && handleIndicator(item);
});


function showTheLoaiPhim(idPhantu, loai,theLoais = undefined) {
    var checkboxTheLoai = document.getElementById(idPhantu);
    var url = DIACHI_API + '/quanlytheloai/*'
    fetch(url)
        .then(response => response.json())
        .then(data => {
            checkboxTheLoai.innerHTML = '';
            data.forEach(theLoai => {
                var html = `<label for="${theLoai.idTheloai}">
                                    <input name="${loai}" type="checkbox" id="${theLoai.idTheloai}" />${theLoai.tenLoai}</label>`
                checkboxTheLoai.innerHTML += html;
            })
        })
        .then(function (){
            if (theLoais != undefined){
                var theLoaiOption = document.querySelectorAll('input[name=theLoaiPhimSua]');
                theLoaiOption.forEach(option => {
                    theLoais.forEach(theloai => {
                        if (theloai.idTheloai == option.getAttribute("id")) {
                            option.checked = true;
                        }
                    })
                })
            }
            else{
                if (checkboxTheLoai.style.display === ""){
                    checkboxTheLoai.style.display = "block";
                }
                else if (checkboxTheLoai.style.display === "none")
                    checkboxTheLoai.style.display = "block";
                else
                    checkboxTheLoai.style.display = "none";
            }
        })
}
//-------------------------------------------------------------------------------------------------------


// phần xử lý dữ liệu
// thêm phim
var phimapi = DIACHI_API + "/quanlyphim/";
function start() {
    handleCreateForm();
}
start();
function handleCreateForm() {
    var createBtn = document.querySelector('#create');
    createBtn.onclick = function () {
        var tenphim = document.querySelector('input[name="ten"]').value;
        var thoiluong = document.querySelector('input[name="thoiluong"]').value;
        var mota = document.querySelector('#mota').value;
        var quocgia = document.querySelector('input[name="quocgia"]').value;
        var trangthai = document.querySelector('#trangthai').value;
        var hinh = document.getElementById('file-upload')

        var theLoaiPhims = document.querySelectorAll('input[name=theLoaiPhim]:checked');
        var listTheLoai = new Array();
        theLoaiPhims.forEach(theLoai => {
            listTheLoai.push(theLoai.getAttribute("id"));
        })

        var hinhData = new FormData();
        hinhData.append("hinh", hinh.files[0]);
        hinhData.append("tenPhim", tenphim);
        hinhData.append("thoiLuong", thoiluong);
        hinhData.append("moTa", mota);
        hinhData.append("quocGia", quocgia);
        hinhData.append("trangThai", trangthai);
        hinhData.append("theLoai", listTheLoai);

        if (tenphim.length == 0) {
            alert("Hãy Nhập Tên Phim")
        }
        if (thoiluong.length == 0) {
            alert("Hãy Nhập Thời lượng")
        }
        else
            CreatePhim(hinhData);
    }
    //define dữ liệu post
}
function CreatePhim(data) {

    options = {
        method: 'POST',
        headers: {
        },
        body: data

    };
    fetch(phimapi, options)
        .then(function (response) {

        })
}

// sửa phim
function layListPhim(){
    var url = DIACHI_API + '/quanlyphim/';
    fetch(url)
        .then(response => response.json())
        .then(listPhim => {
            hienThiListPhim(listPhim);
        })
}

// Hiển thị danh sách phim
function hienThiListPhim(listPhim) {
    var danhsach = document.querySelector('#listphim1');
    danhsach.innerHTML = '';
    listPhim.forEach(function (phim, index){
        var theloai = phim.theLoais.map(data => data.tenLoai).join(", ");
        var trangThai = "Phim sắp chiếu"
        if (phim.trangThai == 1)
            trangThai = "Phim đang chiếu";
        if (phim.trangThai == 2)
            trangThai = "PHim đặc biệt"

        var html = `
                  <div class="phimsss listSuaPhim" onclick="layPhimById(${phim.idPhim})">          
                   <div class="ds">${phim.tenPhim}</div>
                   <div class="ds">${phim.thoiLuong} phút</div>
                   <div class="ds">${phim.quocGia}</div>
                   <div class="ds">${trangThai}</div>
                   <div class="ds">${theloai}</div>
                  </div>
                   `;
        danhsach.innerHTML += html;
    })

}
function layPhimById(idPhim){
    var url = DIACHI_API + `/quanlyphim/${idPhim}`
    fetch(url)
        .then(response => response.json())
        .then(phim => {
            showPhimSua(phim);
        })
}

function showPhimSua(phim){
    document.getElementById('tensua').value = phim.tenPhim;
    document.getElementById('thoiluongsu').value = phim.thoiLuong;
    document.getElementById('quocgiasu').value = phim.quocGia;
    document.getElementById('motasua').value = phim.moTa;
    document.getElementById("suaphim").setAttribute("idPhim", phim.idPhim)
    var trangThaiSelect = document.getElementById('trangthaisua');
    for(let i=0; i<trangThaiSelect.length; i++){
        if (trangThaiSelect.options[i].value == phim.trangThai){
            trangThaiSelect.value = phim.trangThai;
        }
    }
    showTheLoaiPhim('cbTheLoaiSua','theLoaiPhimSua' ,phim.theLoais);
}

function handleSetForm() {
        var tenphim = document.querySelector('input[name="tensua"]').value;
        var thoiluong = document.querySelector('input[name="thoiluongsua"]').value;
        var mota = document.querySelector('#motasua').value;
        var quocgia = document.querySelector('input[name="quocgiasua"]').value;
        var idPhim = document.getElementById("suaphim").getAttribute("idphim");
        var trangthai = document.querySelector('#trangthaisua').value;


        var theLoaiPhims = document.querySelectorAll('input[name=theLoaiPhimSua]:checked');
        var listTheLoai = new Array();
        theLoaiPhims.forEach(theLoai => {
            listTheLoai.push(theLoai.getAttribute("id"));
        })

        console.log(trangthai);
        var formData = new FormData();
        formData.append("idPhim", idPhim);
        formData.append("tenPhim", tenphim);
        formData.append("thoiLuong", thoiluong);
        formData.append("moTa", mota);
        formData.append("quocGia", quocgia);
        formData.append("trangThai", trangthai);
        formData.append("theLoai", listTheLoai);


        if (tenphim.length == 0) {
            alert("Hãy Nhập Tên Phim")
        }
        if (thoiluong.length == 0) {
            alert("Hãy Nhập Thời lượng")
        }
        else{
            var url = DIACHI_API + "/quanlyphim/";
            fetch(url, {
                method: "PUT",
                body: formData
            })
                .then(function (){
                    layListPhim();
                })
        }
    //define dữ liệu Put
}
// tim phim
function timPhim(){
    var key = document.getElementById('nhapten').value;
    var url = DIACHI_API + "/quanlyphim?key=" + key;
    fetch(url)
        .then(response => response.json())
        .then(listPhim => {
            console.log(listPhim)
            hienThiListPhim(listPhim);
        })
}